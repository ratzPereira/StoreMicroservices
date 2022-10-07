package com.ratz.orderservice.dto;

import com.ratz.orderservice.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {


    private long productId;
    private long quantity;
    private long amount;

    private PaymentMode paymentMode;
}
