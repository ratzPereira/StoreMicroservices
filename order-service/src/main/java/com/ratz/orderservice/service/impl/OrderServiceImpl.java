package com.ratz.orderservice.service.impl;

import com.ratz.orderservice.dto.OrderRequestDTO;
import com.ratz.orderservice.entity.Order;
import com.ratz.orderservice.external.client.ProductService;
import com.ratz.orderservice.repository.OrderRepository;
import com.ratz.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    @Override
    public long placeOrder(OrderRequestDTO orderRequestDTO) {

        log.info("Placing order request {}" , orderRequestDTO);

        productService.reduceQuantity(orderRequestDTO.getProductId(), orderRequestDTO.getQuantity());

        log.info("Creating order Status CREATED");

        Order order = Order.builder()
                .amount(orderRequestDTO.getAmount())
                .orderStatus("CREATED")
                .productId(orderRequestDTO.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequestDTO.getQuantity())
                .build();

        orderRepository.save(order);
        log.info("Saved order request {}" , order.getId());
        return order.getId();
    }
}
