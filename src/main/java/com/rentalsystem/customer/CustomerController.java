package com.rentalsystem.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/customer", "/customers"})
public class CustomerController {

    @GetMapping("/list")
    public String listCustomers() {
        return "customer/list-customers";
    }

    @GetMapping("/register")
    public String registerCustomer() {
        return "customer/register-customer";
    }

    @GetMapping("/update")
    public String updateCustomer() {
        return "customer/update-customer";
    }

    @GetMapping("/search")
    public String searchCustomer() {
        return "customer/search-customer";
    }
}