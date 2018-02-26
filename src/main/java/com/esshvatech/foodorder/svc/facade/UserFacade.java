package com.esshvatech.foodorder.svc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esshvatech.foodorder.svc.model.ApplicationUser;
import com.esshvatech.foodorder.svc.repository.UserRepository;

@Component
public class UserFacade {

	@Autowired
	UserRepository userRepository;
	
	public ApplicationUser saveUser(ApplicationUser user) {
		userRepository.save(user);
		return user;
	}
	
	public ApplicationUser getById(String userId) {
		return userRepository.findOne(userId);
	}
	
	public ApplicationUser getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
