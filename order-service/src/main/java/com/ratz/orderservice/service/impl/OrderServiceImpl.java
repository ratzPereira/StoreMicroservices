package com.ratz.orderservice.service.impl;

import com.ratz.orderservice.dto.OrderRequestDTO;
import com.ratz.orderservice.dto.OrderResponseDTO;
import com.ratz.orderservice.entity.Order;
import com.ratz.orderservice.exception.CustomException;
import com.ratz.orderservice.external.client.PaymentService;
import com.ratz.orderservice.external.client.ProductService;
import com.ratz.orderservice.external.request.PaymentRequest;
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
    private final PaymentService paymentService;

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
        log.info("Call payment service");

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .id(order.getId())
                .paymentMode(orderRequestDTO.getPaymentMode())
                .amount(orderRequestDTO.getAmount())
                .build();

        String orderStatus = null;

        try {
            paymentService.doPayment(paymentRequest);
            log.info("Called payment service successful");
            orderStatus = "PLACED";

        }catch (Exception e) {

            log.error("Error in payment");
            orderStatus = "FAILED";
        }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);

        log.info("Saved order request {}" , order.getId());
        return order.getId();
    }

    @Override
    public OrderResponseDTO getOrderDetails(long orderId) {

         Order order = orderRepository.findById(orderId).orElseThrow(()-> new CustomException("Order not found for the id " + orderId, "NOT_FOUND", 404));

        return OrderResponseDTO.builder()
                .amount(order.getAmount())
                .orderDate(order.getOrderDate())
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .build();
    }
}
