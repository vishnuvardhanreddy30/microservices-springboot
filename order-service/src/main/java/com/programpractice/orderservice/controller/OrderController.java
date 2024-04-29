package com.programpractice.orderservice.controller;

import com.programpractice.orderservice.dto.OrderDto;
import com.programpractice.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return "Order Created Successfully";
    }
}
