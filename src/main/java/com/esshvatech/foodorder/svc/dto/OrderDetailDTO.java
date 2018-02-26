package com.esshvatech.foodorder.svc.dto;

import java.util.List;

import com.esshvatech.foodorder.svc.model.OrderDetail;
import com.esshvatech.foodorder.svc.model.OrderIngredient;

public class OrderDetailDTO {
	private OrderDetail orderDetail;
	private List<String> ingredients;
	
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
}
