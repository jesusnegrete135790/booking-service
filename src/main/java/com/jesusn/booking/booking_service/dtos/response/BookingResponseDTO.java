package com.jesusn.booking.booking_service.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record BookingResponseDTO(Integer id,
                                 LocalDateTime bookingDate,
                                 String status,
                                 BigDecimal totalAmount,
                                 CustomerResponseDTO customer,
                                 List<BookingItemResponseDTO> items) {
}
