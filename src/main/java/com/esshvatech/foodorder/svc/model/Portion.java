package com.esshvatech.foodorder.svc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "portion")
@EntityListeners(AuditingEntityListener.class)
public class Portion extends BaseEntity implements Serializable{
	private String displayName;
	private String name;
	private Double price;
	private int setmenu_type; // 1- kottu setmenu
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getSetmenu_type() {
		return setmenu_type;
	}
	public void setSetmenu_type(int setmenu_type) {
		this.setmenu_type = setmenu_type;
	}
		
}
