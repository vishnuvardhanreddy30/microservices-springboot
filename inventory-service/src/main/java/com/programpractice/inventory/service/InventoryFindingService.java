package com.programpractice.inventory.service;

import com.programpractice.inventory.model.Inventory;
import com.programpractice.inventory.model.InventoryResponse;
import com.programpractice.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
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
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        List<InventoryResponse> response = inventoryRepository.findByskuCodeIn(skuCode)
                .stream().map(this::mapInventory).collect(Collectors.toList());
        log.info("Inventory response: "+response);
        return response;
    }

    private InventoryResponse mapInventory(Inventory inventory) {
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0).build();
    }
}
