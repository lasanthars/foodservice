package com.esshvatechq.foodorder.svc.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.esshvatechq.foodorder.svc.dto.OrderDTO;
import com.esshvatechq.foodorder.svc.dto.OrderDetailDTO;
import com.esshvatechq.foodorder.svc.model.Order;
import com.esshvatechq.foodorder.svc.model.OrderDetail;
import com.esshvatechq.foodorder.svc.model.OrderIngredient;
import com.esshvatechq.foodorder.svc.repository.OrderDetailRepository;
import com.esshvatechq.foodorder.svc.repository.OrderIngredientRepository;
import com.esshvatechq.foodorder.svc.repository.OrderRepository;

@Component
public class OrderFacade {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderIngredientRepository orderIngredientRepository;
	
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
}
