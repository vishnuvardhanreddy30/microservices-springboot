package com.programpractice.orderservice.repository;

import com.programpractice.orderservice.model.Order;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Observed
public interface OrdereServiceRepository extends JpaRepository<Order, Long>  {
}
