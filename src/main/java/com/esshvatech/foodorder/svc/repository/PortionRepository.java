package com.esshvatech.foodorder.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatech.foodorder.svc.model.Portion;

@Repository
public interface PortionRepository extends JpaRepository<Portion, String>{

}
