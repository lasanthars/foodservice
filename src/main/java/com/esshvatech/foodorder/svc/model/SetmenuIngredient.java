package com.esshvatech.foodorder.svc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "setmenu_ingredient")
@EntityListeners(AuditingEntityListener.class)
public class SetmenuIngredient extends BaseEntity implements Serializable {

	private String setmenuId;
	private String ingredientId;
	
	public String getSetmenuId() {
		return setmenuId;
	}
	public void setSetmenuId(String setmenuId) {
		this.setmenuId = setmenuId;
	}
	public String getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}
		
}
