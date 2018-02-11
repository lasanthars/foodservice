package com.esshvatechq.foodorder.svc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esshvatechq.foodorder.svc.facade.MenuFacade;
import com.esshvatechq.foodorder.svc.model.FoodItem;

@RestController
@RequestMapping("/api")
public class MenuItemController {

	@Autowired
	MenuFacade menuFacade;
	
	@GetMapping("/menuitems")
	public ResponseEntity<List<FoodItem>> getMenuItems(){
		List<FoodItem> menuItems = menuFacade.getMenuList();
		return ResponseEntity.ok(menuItems);
	}
}
