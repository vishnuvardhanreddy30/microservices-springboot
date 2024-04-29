package com.programpractice.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderListItems {

    private Long id;
    private String skuCode;
    private BigDecimal price;
    private String quantity;
}
