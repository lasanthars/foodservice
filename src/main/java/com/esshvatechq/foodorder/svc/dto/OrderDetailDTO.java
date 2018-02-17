package com.esshvatechq.foodorder.svc.dto;

import java.util.List;

import com.esshvatechq.foodorder.svc.model.OrderDetail;
import com.esshvatechq.foodorder.svc.model.OrderIngredient;

public class OrderDetailDTO {
	private OrderDetail orderDetail;
	private List<OrderIngredient> orderDetailIngredients;
	
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public List<OrderIngredient> getOrderDetailIngredients() {
		return orderDetailIngredients;
	}
	public void setOrderDetailIngredients(List<OrderIngredient> orderDetailIngredients) {
		this.orderDetailIngredients = orderDetailIngredients;
	}
	
	
}
