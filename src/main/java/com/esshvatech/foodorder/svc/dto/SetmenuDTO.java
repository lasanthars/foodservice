package com.esshvatech.foodorder.svc.dto;

import java.util.List;

import com.esshvatech.foodorder.svc.model.Ingredient;
import com.esshvatech.foodorder.svc.model.Portion;
import com.esshvatech.foodorder.svc.model.Setmenu;

public class SetmenuDTO {

	private Setmenu setmenu;
	private List<Ingredient> ingredients;
	private List<Portion> portions;
	
	public Setmenu getSetmenu() {
		return setmenu;
	}
	public void setSetmenu(Setmenu setmenu) {
		this.setmenu = setmenu;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingridients) {
		this.ingredients = ingridients;
	}
	public List<Portion> getPortions() {
		return portions;
	}
	public void setPortions(List<Portion> portions) {
		this.portions = portions;
	}
	
	
}
