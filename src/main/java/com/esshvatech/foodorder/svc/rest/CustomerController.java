package com.esshvatech.foodorder.svc.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esshvatech.foodorder.svc.facade.CustomerFacade;
import com.esshvatech.foodorder.svc.model.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerFacade customerFacade;
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") String customerId){
		Customer customer = customerFacade.getCustomerById(customerId);
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerFacade.saveCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/customer/")
	public ResponseEntity<Customer> getByEmail(@RequestParam(value = "email") String email) {
		Customer customer = customerFacade.getByEmail(email);
		if(customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer); 
	}
}