package com.esshvatech.foodorder.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatech.foodorder.svc.model.ApplicationUser;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, String> {
	ApplicationUser findByEmail(String email);
	
	ApplicationUser findByUsername(String userName);
}

