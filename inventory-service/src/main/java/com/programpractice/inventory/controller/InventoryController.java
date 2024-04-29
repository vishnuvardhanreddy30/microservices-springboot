package com.programpractice.inventory.controller;

import com.programpractice.inventory.model.InventoryResponse;
import com.programpractice.inventory.service.InventoryFindingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryFindingService inventoryService;
    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {

        return inventoryService.isInStock(skuCode);
    }
}
