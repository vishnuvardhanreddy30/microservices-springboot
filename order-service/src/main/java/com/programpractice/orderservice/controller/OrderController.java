package com.programpractice.orderservice.controller;

import com.programpractice.orderservice.dto.OrderDto;
import com.programpractice.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallBackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> createOrder(@RequestBody OrderDto orderDto) {

        return CompletableFuture.supplyAsync(() -> orderService.createOrder(orderDto));
    }

    public CompletableFuture<String> fallBackMethod(OrderDto orderDto, RuntimeException runtimeException) {

        return CompletableFuture.supplyAsync(() -> "Oops !! .... Something went wring. Please order after sometime.");
    }
}
