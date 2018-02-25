package com.esshvatechq.foodorder.svc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "order_detail")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail extends BaseEntity implements Serializable {

	private String orderId;
	private String itemId;
	private Boolean isCustom;
	private String setmenuId;
	private Double qty;
	private Double price;
	private Double total;
	private String portionId;
	private String carbId;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Boolean getIsCustom() {
		return isCustom;
	}
	public void setIsCustom(Boolean isCustom) {
		this.isCustom = isCustom;
	}
	public String getSetmenuId() {
		return setmenuId;
	}
	public void setSetmenuId(String setmenuId) {
		this.setmenuId = setmenuId;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getPortionId() {
		return portionId;
	}
	public void setPortionId(String portionId) {
		this.portionId = portionId;
	}
	public String getCarbId() {
		return carbId;
	}
	public void setCarbId(String carbId) {
		this.carbId = carbId;
	}
	
	
}
