package com.ratz.paymentservice.service;

import com.ratz.paymentservice.dto.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
