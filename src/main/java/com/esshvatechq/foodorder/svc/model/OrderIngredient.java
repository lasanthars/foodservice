package com.esshvatechq.foodorder.svc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_ingredient")
@EntityListeners(AuditingEntityListener.class)
public class OrderIngredient extends BaseEntity implements Serializable{
	private String orderDetailId;
	private String ingredientId;
	
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}
		
}
