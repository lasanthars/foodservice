package com.esshvatechq.foodorder.svc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatechq.foodorder.svc.model.OrderIngredient;

@Repository
public interface OrderIngredientRepository extends JpaRepository<OrderIngredient, String>{

	List<OrderIngredient> findByorderDetailId(String orderDetailId);
}
