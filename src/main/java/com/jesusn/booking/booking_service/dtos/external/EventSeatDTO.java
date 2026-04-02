package com.jesusn.booking.booking_service.dtos.external;

import java.math.BigDecimal;

public record EventSeatDTO(Integer id,
                           String status,
                           BigDecimal price) {
}
