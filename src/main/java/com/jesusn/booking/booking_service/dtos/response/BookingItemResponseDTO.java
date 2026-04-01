package com.jesusn.booking.booking_service.dtos.response;



import java.math.BigDecimal;

public record BookingItemResponseDTO(Integer id,
                                     Integer eventSeatId,
                                     BigDecimal price) {
}
