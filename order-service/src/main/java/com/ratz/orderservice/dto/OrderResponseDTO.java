package com.ratz.orderservice.dto;

import com.ratz.orderservice.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {

    private long orderId;
    private String orderStatus;
    private Instant orderDate;
    private long amount;
    private ProductDetails productDetails;
    private PaymentDetails paymentResponseDTO;


    @Data
    @Builder
    public static class ProductDetails {

        private long productId;
        private long price;
        private long quantity;
        private String productName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PaymentDetails {

        private long paymentId;
        private PaymentMode paymentMode;
        private Instant paymentDate;
        private String paymentStatus;

    }
}
