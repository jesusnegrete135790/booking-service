package com.jesusn.booking.booking_service.dtos.request;

import com.jesusn.booking.booking_service.entities.Booking;

import java.math.BigDecimal;

public record BookingItemRequestDTO(Booking booking,
                                    Integer eventSeatId,
                                    BigDecimal price) {
}
