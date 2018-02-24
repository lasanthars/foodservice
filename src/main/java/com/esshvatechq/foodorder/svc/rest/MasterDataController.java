package com.esshvatechq.foodorder.svc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esshvatechq.foodorder.svc.facade.MasterDataFacade;

@RestController
@RequestMapping("/secure/api/masterinfo")
public class MasterDataController {

	@Autowired
	MasterDataFacade masterDataFacade;
	
	
}
