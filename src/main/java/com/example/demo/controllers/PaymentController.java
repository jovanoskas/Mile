package com.example.demo.controllers;

import com.example.demo.model.dto.ChargeRequest;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private PaymentService stripeClient;

    @Autowired
    PaymentController(PaymentService stripeClient) {
        this.stripeClient = stripeClient;
    }

   // @PostMapping
//    public Charge chargeCard(ChargeRequest request) throws Exception {
//        String token = request.getStripeToken();
//        Double amount = Double.parseDouble(String.valueOf(request.getAmount()));
//        return this.stripeClient.pay(request);
//    }
}