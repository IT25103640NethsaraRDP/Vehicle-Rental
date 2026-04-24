package com.rentalsystem.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/payment", "/payments"})
public class PaymentController {

    @GetMapping("/list")
    public String listPayments() {
        return "payment/list-payments";
    }

    @GetMapping("/process")
    public String processPayment() {
        return "payment/process-payment";
    }
}