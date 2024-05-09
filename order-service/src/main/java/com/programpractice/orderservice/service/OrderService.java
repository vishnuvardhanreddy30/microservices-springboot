package com.programpractice.orderservice.service;

import com.programpractice.orderservice.dto.OrderDto;
import com.programpractice.orderservice.dto.OrderListItems;
import com.programpractice.orderservice.event.OrderPlacedEvent;
import com.programpractice.orderservice.model.InventoryResponse;
import com.programpractice.orderservice.model.ProductOrder;
import com.programpractice.orderservice.model.OrderItems;
import com.programpractice.orderservice.repository.OrdereServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrdereServiceRepository ordereServiceRepository;
    private final WebClient.Builder webClientBuilder;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public String createOrder(OrderDto orderDto) {
        ProductOrder order = new ProductOrder();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItems> orderItems = orderDto.getOrderListItemsList().stream()
                .map(this::mapOrderItems).toList();
        order.setOrderItemsList(orderItems);

       List<String> skuCodes = orderDto.getOrderListItemsList().stream().map(OrderListItems::getSkuCode)
                .toList();

        // call inventory api using webclient with loadbalanced eureka server
        //Even after initially taking down the discovery-server, order-service still finds the inventory-service
        // as the client server stores the copy of discovery-server
        InventoryResponse[] result =  webClientBuilder.build().get()
                        .uri("http://INVENTORY-SERVICE/api/inventory",
                                uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                                .retrieve()
                                        .bodyToMono(InventoryResponse[].class)
                                                .block();
       boolean isAllProductsInStock = Arrays.stream(result).allMatch(InventoryResponse::isInStock);
        if (isAllProductsInStock) {
            ordereServiceRepository.save(order);
            kafkaTemplate.send("notificationTopic", OrderPlacedEvent.builder().orderNumber(order.getOrderNumber()).build());
            return "Order Created Successfully";
        }
        else
        {
            throw new IllegalArgumentException("No skuCode is available, please try again later!");
        }
    }

    private OrderItems mapOrderItems(OrderListItems orderListItems) {
        return OrderItems.builder().skuCode(orderListItems.getSkuCode())
                .price(orderListItems.getPrice())
                .quantity(orderListItems.getQuantity()).build();
    }
}
