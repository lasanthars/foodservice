package com.esshvatech.foodorder.svc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatech.foodorder.svc.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{

	List<Order> findBystatus(int status);
}
