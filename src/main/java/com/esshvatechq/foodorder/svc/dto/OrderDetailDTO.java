package com.esshvatechq.foodorder.svc.dto;

import java.util.List;

import com.esshvatechq.foodorder.svc.model.OrderDetail;
import com.esshvatechq.foodorder.svc.model.OrderIngredient;

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
