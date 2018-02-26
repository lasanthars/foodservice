package com.esshvatech.foodorder.svc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esshvatech.foodorder.svc.model.Customer;
import com.esshvatech.foodorder.svc.repository.CustomerRepository;

@Component
public class CustomerFacade {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomerById(String id) {
		Customer customer = customerRepository.findOne(id);
		return customer;
	}
	
	public Customer saveCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	
	public Customer getByEmail(String email) {
		return customerRepository.findByemail(email);
	}
}
