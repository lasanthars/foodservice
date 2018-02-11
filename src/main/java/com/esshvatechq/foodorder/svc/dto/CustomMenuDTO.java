package com.esshvatechq.foodorder.svc.dto;

import java.util.List;

import com.esshvatechq.foodorder.svc.model.Carb;
import com.esshvatechq.foodorder.svc.model.Ingredient;
import com.esshvatechq.foodorder.svc.model.Portion;

public class CustomMenuDTO {

	private List<Ingredient> ingredients;
	private List<Portion> portions;
	private List<Carb> carbs;
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public List<Portion> getPortions() {
		return portions;
	}
	public void setPortions(List<Portion> portions) {
		this.portions = portions;
	}
	public List<Carb> getCarbs() {
		return carbs;
	}
	public void setCarbs(List<Carb> carbs) {
		this.carbs = carbs;
	}
		
}
