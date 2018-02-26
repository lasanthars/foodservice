package com.esshvatech.foodorder.svc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatech.foodorder.svc.model.Ingredient;;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String>{
	List<Ingredient> findByIdIn(List<String> ingredientIdList);
}
