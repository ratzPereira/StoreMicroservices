package com.ratz.orderservice.controller;

import com.ratz.orderservice.dto.OrderRequestDTO;
import com.ratz.orderservice.dto.OrderResponseDTO;
import com.ratz.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderDetails(@PathVariable long orderId){

        log.info("Getting order id {} details", orderId);
        OrderResponseDTO orderResponseDTO = orderService.getOrderDetails(orderId);

        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }
}
