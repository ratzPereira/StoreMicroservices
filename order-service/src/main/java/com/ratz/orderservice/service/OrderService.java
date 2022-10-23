package com.ratz.orderservice.service;

import com.ratz.orderservice.dto.OrderRequestDTO;
import com.ratz.orderservice.dto.OrderResponseDTO;

public interface OrderService {
    long placeOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrderDetails(long orderId);
}
