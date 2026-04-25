package com.rentalsystem.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/booking", "/bookings"})
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/list")
    public String listBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "booking/list-bookings";
    }

    @GetMapping("/book")
    public String showBookVehicleForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking/book-vehicle";
    }

    @PostMapping("/book")
    public String createBooking(@ModelAttribute Booking booking, Model model) {
        try {
            Booking created = bookingService.createBooking(booking);
            return "redirect:/bookings/list?success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "booking/book-vehicle";
        }
    }

    @GetMapping("/return")
    public String showReturnForm(@RequestParam Long id, Model model) {
        Optional<Booking> bookingOpt = bookingService.getBookingById(id);
        if (bookingOpt.isPresent()) {
            model.addAttribute("booking", bookingOpt.get());
        }
        return "booking/return-vehicle";
    }

    @PostMapping("/return")
    public String returnVehicle(@RequestParam Long id, Model model) {
        try {
            bookingService.returnBooking(id);
            return "redirect:/bookings/list?returned";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/bookings/list?error";
        }
    }

    @PostMapping("/confirm")
    public String confirmBooking(@RequestParam Long id) {
        bookingService.confirmBooking(id);
        return "redirect:/bookings/list";
    }

    @PostMapping("/cancel")
    public String cancelBooking(@RequestParam Long id) {
        bookingService.cancelBooking(id);
        return "redirect:/bookings/list";
    }

    @PostMapping("/delete")
    public String deleteBooking(@RequestParam Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings/list";
    }
}