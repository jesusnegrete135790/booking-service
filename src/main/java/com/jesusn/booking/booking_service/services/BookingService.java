package com.jesusn.booking.booking_service.services;

import com.jesusn.booking.booking_service.dtos.request.BookingRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.BookingResponseDTO;

import java.util.List;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO request);

    BookingResponseDTO getBookingById(Integer id);

    List<BookingResponseDTO> getBookingsByCustomerId(Integer customerId);
}
