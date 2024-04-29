package com.programpractice.inventory.repository;

import com.programpractice.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    List<Inventory> findByskuCodeIn(List<String> skuCode);
}
