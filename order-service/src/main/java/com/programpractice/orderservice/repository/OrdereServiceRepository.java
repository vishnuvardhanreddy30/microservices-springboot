package com.programpractice.orderservice.repository;

import com.programpractice.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdereServiceRepository extends JpaRepository<Order, Long>  {
}
