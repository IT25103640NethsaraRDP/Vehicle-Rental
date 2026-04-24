package com.rentalsystem.booking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/booking", "/bookings"})
public class BookingController {

    @GetMapping("/list")
    public String listBookings() {
        return "booking/list-bookings";
    }

    @GetMapping("/book")
    public String bookVehicle() {
        return "booking/book-vehicle";
    }

    @GetMapping("/return")
    public String returnVehicle() {
        return "booking/return-vehicle";
    }
}