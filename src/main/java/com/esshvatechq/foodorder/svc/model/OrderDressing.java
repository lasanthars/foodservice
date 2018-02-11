package com.esshvatechq.foodorder.svc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_dressing")
@EntityListeners(AuditingEntityListener.class)
public class OrderDressing extends BaseEntity implements Serializable{

	private String orderDetailId;
	private String dressingId;
	
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getDressingId() {
		return dressingId;
	}
	public void setDressingId(String dressingId) {
		this.dressingId = dressingId;
	}
	
	
}
