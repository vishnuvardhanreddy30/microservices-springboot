package com.programpractice.orderservice.repository;

import com.programpractice.orderservice.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdereServiceRepository extends JpaRepository<ProductOrder, String>  {
}
