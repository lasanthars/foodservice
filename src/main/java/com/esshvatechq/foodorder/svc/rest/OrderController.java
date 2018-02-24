package com.esshvatechq.foodorder.svc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esshvatechq.foodorder.svc.dto.OrderDTO;
import com.esshvatechq.foodorder.svc.facade.OrderFacade;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderFacade orderFacade;
	
	@PostMapping("/order")
	public ResponseEntity saveOrder(@RequestBody OrderDTO orderDto) {
		try {
			orderFacade.saveOrder(orderDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO log error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/secure/order/{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable(value = "id") String orderId) {
		OrderDTO orderDTO;
		try {
			orderDTO = orderFacade.getOrder(orderId);
			return ResponseEntity.ok(orderDTO);
		} catch (Exception e) {
			// TODO log error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/orders/neworders")
	public ResponseEntity<List<OrderDTO>> getNewOrders (){
		List<OrderDTO> orderDTOList;
		try {
			orderDTOList = orderFacade.getNewOrders();
			return ResponseEntity.ok(orderDTOList);
		} catch (Exception e) {
			// TODO log error
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
