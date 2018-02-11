package com.esshvatechq.foodorder.svc.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esshvatechq.foodorder.svc.dto.CustomMenuDTO;
import com.esshvatechq.foodorder.svc.dto.SetmenuDTO;
import com.esshvatechq.foodorder.svc.model.Carb;
import com.esshvatechq.foodorder.svc.model.FoodItem;
import com.esshvatechq.foodorder.svc.model.Ingredient;
import com.esshvatechq.foodorder.svc.model.Portion;
import com.esshvatechq.foodorder.svc.model.Setmenu;
import com.esshvatechq.foodorder.svc.model.SetmenuIngredient;
import com.esshvatechq.foodorder.svc.repository.CarbRepository;
import com.esshvatechq.foodorder.svc.repository.FoodItemRepository;
import com.esshvatechq.foodorder.svc.repository.IngredientRepository;
import com.esshvatechq.foodorder.svc.repository.PortionRepository;
import com.esshvatechq.foodorder.svc.repository.SetmenuIngredientRepository;
import com.esshvatechq.foodorder.svc.repository.SetmenuRepository;

@Component
public class MenuFacade {

	@Autowired
	private SetmenuRepository setmenuRepository;
	
	@Autowired
	private SetmenuIngredientRepository setmenuIngredientRepository;
	
	@Autowired
	private PortionRepository portionRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private CarbRepository carbRepository;
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	public List<SetmenuDTO> getSetmenuList(){
		List<SetmenuDTO> setmenuDtoList = new ArrayList<>();
		
		List<Setmenu> setmenus = setmenuRepository.findAll();
		List<Ingredient> ingredients = new ArrayList<>();
		List<Portion> portions = portionRepository.findAll();
		
		if(!setmenus.isEmpty()) {
			for (Setmenu setmenu : setmenus) {
				
				List<SetmenuIngredient> setmenuIngredients = setmenuIngredientRepository.findBysetmenuId(setmenu.getId());
				for (SetmenuIngredient setmenuIngredient : setmenuIngredients) {
					Ingredient ingredient = ingredientRepository.findOne(setmenuIngredient.getIngredientId());
					ingredients.add(ingredient);
				}
				
				SetmenuDTO setmenuDto = new SetmenuDTO();
				setmenuDto.setSetmenu(setmenu);
				setmenuDto.setIngredients(ingredients);
				setmenuDto.setPortions(portions);
				setmenuDtoList.add(setmenuDto);
			}
		}
		
		return setmenuDtoList;
	}
	
	public CustomMenuDTO getCustomMenuTemplate() {
		List<Ingredient> ingredients = ingredientRepository.findAll();
		List<Portion> portions = portionRepository.findAll();
		List<Carb> carbs = carbRepository.findAll();
		
		CustomMenuDTO customMenu = new CustomMenuDTO();
		customMenu.setIngredients(ingredients);
		customMenu.setPortions(portions);
		customMenu.setCarbs(carbs);
		
		return customMenu;
	}

	public List<FoodItem> getMenuList(){
		List<FoodItem> menuItems = foodItemRepository.findAll();
		return menuItems;
	}
}
