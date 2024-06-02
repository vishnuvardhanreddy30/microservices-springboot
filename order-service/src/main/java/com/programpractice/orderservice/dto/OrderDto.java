package com.programpractice.orderservice.dto;

import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
