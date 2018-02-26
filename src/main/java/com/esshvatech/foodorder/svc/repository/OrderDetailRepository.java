package com.esshvatech.foodorder.svc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esshvatech.foodorder.svc.model.OrderDetail;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{

	List<OrderDetail> findByorderId(String orderId);
}
