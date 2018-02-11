package com.esshvatechq.foodorder.svc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatechq.foodorder.svc.model.SetmenuIngredient;

@Repository
public interface SetmenuIngredientRepository extends JpaRepository<SetmenuIngredient, String>{

	List<SetmenuIngredient> findBysetmenuId(String setmenuId);
		
}
