package com.ratz.paymentservice.controller;


import com.ratz.paymentservice.dto.PaymentRequest;
import com.ratz.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class PaymentController {


    private final PaymentService paymentService;
    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){

        return new ResponseEntity<>(paymentService.doPayment(paymentRequest), HttpStatus.OK);
    }
}
