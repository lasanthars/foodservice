package com.esshvatechq.foodorder.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatechq.foodorder.svc.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String>{

}
