package com.programpractice.inventory.service;

import com.programpractice.inventory.model.Inventory;
import com.programpractice.inventory.model.InventoryResponse;
import com.programpractice.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryFindingService {

    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    //@SneakyThrows
    public boolean isInStock(String skuCode, int quantity) {

       boolean isInStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
       log.info("Stock available: {}",isInStock);
        return isInStock;
    }

}
