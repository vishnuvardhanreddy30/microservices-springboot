package com.programpractice.orderservice.dto;

import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private List<OrderListItems> orderListItemsList;

}
