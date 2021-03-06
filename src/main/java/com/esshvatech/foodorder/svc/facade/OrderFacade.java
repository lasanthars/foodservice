package com.esshvatech.foodorder.svc.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.esshvatech.foodorder.svc.util.ValidationResponse;
import com.esshvatech.foodorder.svc.dto.OrderDTO;
import com.esshvatech.foodorder.svc.dto.OrderDetailDTO;
import com.esshvatech.foodorder.svc.model.Carb;
import com.esshvatech.foodorder.svc.model.FoodItem;
import com.esshvatech.foodorder.svc.model.Ingredient;
import com.esshvatech.foodorder.svc.model.Order;
import com.esshvatech.foodorder.svc.model.OrderDetail;
import com.esshvatech.foodorder.svc.model.OrderIngredient;
import com.esshvatech.foodorder.svc.model.Portion;
import com.esshvatech.foodorder.svc.repository.CarbRepository;
import com.esshvatech.foodorder.svc.repository.FoodItemRepository;
import com.esshvatech.foodorder.svc.repository.IngredientRepository;
import com.esshvatech.foodorder.svc.repository.OrderDetailRepository;
import com.esshvatech.foodorder.svc.repository.OrderIngredientRepository;
import com.esshvatech.foodorder.svc.repository.OrderRepository;
import com.esshvatech.foodorder.svc.repository.PortionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class OrderFacade {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderIngredientRepository orderIngredientRepository;
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	@Autowired
	private CarbRepository  carbRepository;
	
	@Autowired
	private PortionRepository portionRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	public OrderDTO saveOrder(OrderDTO orderDto) throws Exception {
		
		if(orderDto.getOrder() == null) {
			throw new Exception("Invalild order infomation");
		}
		
		if(orderDto.getOrderDetailDTO() == null && orderDto.getOrderDetailDTO().isEmpty()) {
			throw new Exception("Invalid order detail");
		}
		
		Order order = orderDto.getOrder();
		orderRepository.save(order);
		
		List<OrderDetailDTO> orderDetailDTOList = orderDto.getOrderDetailDTO();
		for (OrderDetailDTO orderDetailDTO : orderDetailDTOList) {
			OrderDetail orderDetail = orderDetailDTO.getOrderDetail();
			orderDetail.setOrderId(order.getId());
			orderDetailRepository.save(orderDetail);
			if(orderDetailDTO.getIngredients() != null) {
				List<String> ingredients = orderDetailDTO.getIngredients();
				if(!ingredients.isEmpty()) {
					for (String orderIngredientId : ingredients) {
						OrderIngredient orderIngredient = new OrderIngredient();
						orderIngredient.setOrderDetailId(orderDetail.getId());
						orderIngredient.setIngredientId(orderIngredientId);
						orderIngredientRepository.save(orderIngredient);
					}
				}
			}
		}
		
		return orderDto;
	}
	
	public OrderDTO getOrder(String orderId) throws Exception {
		if(orderId.isEmpty()) {
			throw new Exception("Invalid order id.");
		}
		
		Order order = orderRepository.findOne(orderId);
		if(order == null || order.getId().isEmpty()) {
			throw new Exception("Order not found");
		}
		
		List<OrderDetail> orderDetails = orderDetailRepository.findByorderId(orderId);
		if(orderDetails.isEmpty()) {
			throw new Exception("Order detail not found for given order id : " + orderId);
		}
		
		List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
			orderDetailDTO.setOrderDetail(orderDetail);
			if(orderDetail.getIsCustom()) {
				List<OrderIngredient> orderIngredients = orderIngredientRepository.findByorderDetailId(orderDetail.getId());
				//orderDetailDTO.setOrderDetailIngredients(orderIngredients);
			}
			orderDetailDTOList.add(orderDetailDTO);
		}
		
		OrderDTO orderDto = new OrderDTO();
		orderDto.setOrder(order);
		orderDto.setOrderDetailDTO(orderDetailDTOList);
		
		return orderDto;
	}
	
	public List<OrderDTO> getNewOrders(){
		List<OrderDTO> orderDTOList = new ArrayList<>();
		List<Order> orders = orderRepository.findBystatus(0);
		for (Order order : orders) {
			OrderDTO orderDto = new OrderDTO();
			orderDto.setOrder(order);
			orderDTOList.add(orderDto);
		}
		
		return orderDTOList;
	}
	
	public ValidationResponse validateOrder(OrderDTO orderDTO) {
		log.info("Validating order");
		ValidationResponse validationResponse = new ValidationResponse();
		double calculatedOrderTotal = 0;
		double orderTotalReceivedFromFrontEnd = orderDTO.getOrder().getNettTotal();
		List<OrderDetailDTO> orderDetailDTOList = orderDTO.getOrderDetailDTO();
		for (OrderDetailDTO orderDetailDTO : orderDetailDTOList) {
			OrderDetail orderDetail = orderDetailDTO.getOrderDetail();
			String itemId = orderDetail.getItemId();
			
			if(!orderDetail.getIsCustom()) {
				FoodItem item = foodItemRepository.findOne(itemId);
				if(item != null) {
					double itemPrice = item.getPrice();
					calculatedOrderTotal += itemPrice;
					
				}
			}
			else{
				//validation for custom kottu.
				if(StringUtils.isBlank(orderDetail.getPortionId())){
					validationResponse.setStatus(HttpStatus.BAD_REQUEST);
					validationResponse.setMessage("Portion can not be empty in custom kottu");
					log.info("Portion can not be empty in custom kottu");
					return validationResponse;
				}
				if(StringUtils.isBlank(orderDetail.getCarbId())){
					log.info("Carb can not be empty in custom kottu");
					validationResponse.setStatus(HttpStatus.BAD_REQUEST);
					validationResponse.setMessage("Carb can not be empty in custom kottu");
					return validationResponse;
				}
				
				Carb carb = carbRepository.findOne(orderDetail.getCarbId());
				if(carb == null) {
					log.info("No such a carb found id : " + orderDetail.getCarbId());
					validationResponse.setStatus(HttpStatus.BAD_REQUEST);
					validationResponse.setMessage("No such a carb found.");
					return validationResponse;
				}
				
				Portion portion = portionRepository.findOne(orderDetail.getPortionId());
				if(portion == null) {
					log.info("No such a portion found for id : " + orderDetail.getPortionId());
					validationResponse.setStatus(HttpStatus.BAD_REQUEST);
					validationResponse.setMessage("No such a portion found.");
					return validationResponse;
				}
				
				double portionPrice = portion.getPrice();
				double carbPrice = carb.getPrice();
				
				List<OrderIngredient> orderIngredients = orderIngredientRepository.findByorderDetailId(orderDetail.getId());
				if(orderIngredients == null) {
					log.info("Ingredients or Protein can not be empty.");
					validationResponse.setStatus(HttpStatus.BAD_REQUEST);
					validationResponse.setMessage("Ingredients or Protein can not be empty.");
					return validationResponse;
				}
				List<String> ingredientIdList = orderIngredients.stream().map(OrderIngredient:: getIngredientId).collect(Collectors.toList());
				List<Ingredient> ingredients = ingredientRepository.findByIdIn(ingredientIdList);
				double ingredientTotalPrice = ingredients.stream().mapToDouble(Ingredient:: getPrice).sum();
				double totalValueOfCustomKottu = portionPrice + carbPrice + ingredientTotalPrice;
				calculatedOrderTotal += totalValueOfCustomKottu;
			}
			
		}
		
		if(orderTotalReceivedFromFrontEnd != calculatedOrderTotal) {
			log.error("Calculated order total does not tally with the nett total received from fron-end.");
			validationResponse.setStatus(HttpStatus.BAD_REQUEST);
			validationResponse.setMessage("Calculated order total does not tally with the nett total received from fron-end.");
			return validationResponse;
		}
		
		log.info("Order validation success");
		validationResponse.setStatus( HttpStatus.ACCEPTED);
		return validationResponse;
	}
}
