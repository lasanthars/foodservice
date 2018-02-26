package com.esshvatech.foodorder.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatech.foodorder.svc.model.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, String>{

}
