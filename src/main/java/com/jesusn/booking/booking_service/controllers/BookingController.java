package com.jesusn.booking.booking_service.controllers;

import com.jesusn.booking.booking_service.dtos.request.BookingRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.BookingResponseDTO;
import com.jesusn.booking.booking_service.services.BookingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@Valid @RequestBody BookingRequestDTO request) {
        BookingResponseDTO response = bookingService.createBooking(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO>getBookingById(@Valid @PathVariable Integer id){
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<BookingResponseDTO>>getBookingsByCustomerId(@Valid @PathVariable Integer customerId){
        return ResponseEntity.ok(bookingService.getBookingsByCustomerId(customerId));
    }
}