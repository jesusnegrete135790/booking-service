package com.jesusn.booking.booking_service.services;

import com.jesusn.booking.booking_service.dtos.request.BookingRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.BookingResponseDTO;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO request);
}
