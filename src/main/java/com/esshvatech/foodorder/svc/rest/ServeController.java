package com.esshvatech.foodorder.svc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esshvatech.foodorder.svc.dto.CustomMenuDTO;
import com.esshvatech.foodorder.svc.dto.SetmenuDTO;
import com.esshvatech.foodorder.svc.facade.MenuFacade;

@RestController
@RequestMapping("/api")
public class ServeController {

	@Autowired
	MenuFacade menuFacade;
	
	@GetMapping("/setmenus/kottu")
	public ResponseEntity<List<SetmenuDTO>> getSetmenus() {
		List<SetmenuDTO> setmenus = menuFacade.getSetmenuList();
		return ResponseEntity.ok(setmenus);
	}
	
	@GetMapping("custommenus/kottu/template")
	public ResponseEntity<CustomMenuDTO> getCustomMenuTemplate(){
		CustomMenuDTO customMenu = menuFacade.getCustomMenuTemplate();
		return ResponseEntity.ok(customMenu);
	}
	
}
