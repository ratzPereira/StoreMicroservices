package com.ratz.paymentservice.service;

import com.ratz.paymentservice.dto.PaymentRequest;
import com.ratz.paymentservice.dto.PaymentResponseDTO;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponseDTO getPaymentDetailsByOrderId(long orderId);
}
