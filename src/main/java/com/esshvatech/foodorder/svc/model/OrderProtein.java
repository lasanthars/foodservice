package com.esshvatech.foodorder.svc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_protein")
@EntityListeners(AuditingEntityListener.class)
public class OrderProtein extends BaseEntity implements Serializable {

	private String orderDetailId;
	private String proteinId;
	
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getProteinId() {
		return proteinId;
	}
	public void setProteinId(String proteinId) {
		this.proteinId = proteinId;
	}
		
}
