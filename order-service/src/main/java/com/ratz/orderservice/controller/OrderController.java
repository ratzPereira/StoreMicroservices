package com.ratz.orderservice.controller;

import com.ratz.orderservice.dto.OrderRequestDTO;
import com.ratz.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
@Log4j2
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO){

        long orderId = orderService.placeOrder(orderRequestDTO);
        log.info("Order id {} placed", orderId);

        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }
}
