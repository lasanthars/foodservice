
package com.esshvatechq.foodorder.svc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "food_order")
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity implements Serializable {

	private Date orderDate;
	private String customerId;
	private Double grossTotal;
	private Double tax;
	private Double nettTotal;
	private String notes;
	private int status;
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getNettTotal() {
		return nettTotal;
	}
	public void setNettTotal(Double nettTotal) {
		this.nettTotal = nettTotal;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
