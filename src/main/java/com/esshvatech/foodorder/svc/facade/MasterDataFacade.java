package com.esshvatech.foodorder.svc.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esshvatech.foodorder.svc.model.Carb;
import com.esshvatech.foodorder.svc.model.FoodItem;
import com.esshvatech.foodorder.svc.model.Ingredient;
import com.esshvatech.foodorder.svc.model.Portion;
import com.esshvatech.foodorder.svc.model.Setmenu;
import com.esshvatech.foodorder.svc.repository.CarbRepository;
import com.esshvatech.foodorder.svc.repository.FoodItemRepository;
import com.esshvatech.foodorder.svc.repository.IngredientRepository;
import com.esshvatech.foodorder.svc.repository.PortionRepository;
import com.esshvatech.foodorder.svc.repository.SetmenuRepository;


@Component
public class MasterDataFacade {

	@Autowired
	CarbRepository carbRepository;
	
	@Autowired
	FoodItemRepository foodItemRepository;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	PortionRepository portionRepository;
	
	@Autowired
	SetmenuRepository setmenuRepository;
	
	//CRUDS for Carb
	
	public Carb saveCarb(Carb carb) {
		carbRepository.save(carb);
		return carb;
	}
	
	public Carb getCarbById(String id) {
		return carbRepository.findOne(id);
	}
	
	public List<Carb> getCarbs(){
		return carbRepository.findAll();
	}
	
	public void deleteCarb(String id) {
		carbRepository.delete(id);
	}
	
	//CRUDS for Food Items.
	
	public FoodItem saveFoodItem(FoodItem foodItem) {
		foodItemRepository.save(foodItem);
		return foodItem;
	}
	
	public FoodItem getFoodItemById(String id) {
		return foodItemRepository.findOne(id);
	}
	
	public List<FoodItem> getFoodItems(){
		return foodItemRepository.findAll();
	}
	
	public void delteFoodItem(String id) {
		foodItemRepository.delete(id);
	}
	
	//CRUDS for Igredients
	
	public Ingredient saveIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
		return ingredient;
	}
	
	public Ingredient getIngredientById(String id) {
		return ingredientRepository.findOne(id);
	}
	
	public List<Ingredient> getIngredients(){
		return ingredientRepository.findAll();
	}
	
	public void deleteIngredient(String id) {
		ingredientRepository.delete(id);
	}
	
	//CRUDS for Portion
	
	public Portion savePortion(Portion portion) {
		portionRepository.save(portion);
		return portion;
	}
	
	public Portion getPortionById(String id) {
		return portionRepository.findOne(id);
	}
	
	public List<Portion> getPortions(){
		return portionRepository.findAll();
	}
	
	public void deletePortion(String id) {
		portionRepository.delete(id);
	}
	
	//CRUDS for Setmenu
	
	public Setmenu saveSetmenu(Setmenu setmenu) {
		setmenuRepository.save(setmenu);
		return setmenu;
	}
	
	public Setmenu getSetmenuById(String id) {
		return setmenuRepository.findOne(id);
	}
	
	public List<Setmenu> getSetmenus(){
		return setmenuRepository.findAll();
	}
	
	public void deleteSetmenu(String id) {
		setmenuRepository.delete(id);
	}
}
