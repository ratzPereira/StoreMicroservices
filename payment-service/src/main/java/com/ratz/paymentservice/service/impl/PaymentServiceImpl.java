package com.ratz.paymentservice.service.impl;

import com.ratz.paymentservice.dto.PaymentRequest;
import com.ratz.paymentservice.model.TransactionDetails;
import com.ratz.paymentservice.repository.TransactionDetailsRepository;
import com.ratz.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public long doPayment(PaymentRequest paymentRequest) {

        log.info("Recording Payment Details: {}" , paymentRequest);

        TransactionDetails transactionDetails = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();

        transactionDetailsRepository.save(transactionDetails);
        log.info("Saved transaction for order : {}" , paymentRequest.getId());

        return transactionDetails.getId();
    }
}
