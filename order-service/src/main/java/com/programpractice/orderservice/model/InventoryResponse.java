package com.programpractice.orderservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InventoryResponse {
    private String skuCode;
    private boolean inStock;
}
