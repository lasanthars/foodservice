package com.esshvatechq.foodorder.svc.dto;

import java.util.List;

import com.esshvatechq.foodorder.svc.model.Order;
import com.esshvatechq.foodorder.svc.model.OrderDetail;
import com.esshvatechq.foodorder.svc.model.OrderIngredient;

public class OrderDTO {
	private Order order;
	private List<OrderDetailDTO> orderDetailDTO;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetailDTO> getOrderDetailDTO() {
		return orderDetailDTO;
	}

	public void setOrderDetailDTO(List<OrderDetailDTO> orderDetailDTO) {
		this.orderDetailDTO = orderDetailDTO;
	}
}
