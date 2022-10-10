package com.ratz.paymentservice.dto;

import com.ratz.paymentservice.enums.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    private long id;
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
}
