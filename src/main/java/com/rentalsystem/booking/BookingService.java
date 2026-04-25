package com.rentalsystem.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    public List<Booking> getBookingsByVehicleId(Long vehicleId) {
        return bookingRepository.findByVehicleId(vehicleId);
    }

    public List<Booking> getBookingsByStatus(Booking.BookingStatus status) {
        return bookingRepository.findByStatus(status);
    }

    public Booking createBooking(Booking booking) {
        booking.setStatus(Booking.BookingStatus.PENDING);
        booking.setCreatedAt(java.time.LocalDateTime.now());
        
        long days = ChronoUnit.DAYS.between(booking.getBookingDate(), booking.getReturnDate());
        double dailyRate = 50.0;
        booking.setTotalPrice(days * dailyRate);
        
        return bookingRepository.save(booking);
    }

    public Booking confirmBooking(Long id) {
        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus(Booking.BookingStatus.CONFIRMED);
            booking.setUpdatedAt(java.time.LocalDateTime.now());
            return bookingRepository.save(booking);
        }
        return null;
    }

    public Booking activateBooking(Long id) {
        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus(Booking.BookingStatus.ACTIVE);
            booking.setUpdatedAt(java.time.LocalDateTime.now());
            return bookingRepository.save(booking);
        }
        return null;
    }

    public Booking returnBooking(Long id) {
        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus(Booking.BookingStatus.RETURNED);
            booking.setUpdatedAt(java.time.LocalDateTime.now());
            return bookingRepository.save(booking);
        }
        return null;
    }

    public Booking cancelBooking(Long id) {
        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setStatus(Booking.BookingStatus.CANCELLED);
            booking.setUpdatedAt(java.time.LocalDateTime.now());
            return bookingRepository.save(booking);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}