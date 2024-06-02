package com.programpractice.orderservice.service;

import com.programpractice.orderservice.client.InventoryClient;
import com.programpractice.orderservice.dto.OrderDto;
import com.programpractice.orderservice.event.OrderPlacedEvent;
import com.programpractice.orderservice.model.Order;
import com.programpractice.orderservice.repository.OrdereServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrdereServiceRepository orderServiceRepository;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
    private final InventoryClient inventoryClient;

    public String createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderDto.getSkuCode());
        order.setPrice(orderDto.getPrice());
        order.setQuantity(orderDto.getQuantity());

       boolean isAllProductsInStock = inventoryClient.isInStock(orderDto.getSkuCode(), orderDto.getQuantity());
        if (isAllProductsInStock) {
            orderServiceRepository.save(order);
            kafkaTemplate.send("notificationTopic", OrderPlacedEvent.builder().orderNumber(order.getOrderNumber()).build());
            return "Order Created Successfully";
        }
        else
        {
            throw new RuntimeException("No skuCode is available, please try again later!");
        }
    }
}
