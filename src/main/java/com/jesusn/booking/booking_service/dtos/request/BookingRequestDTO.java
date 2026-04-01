package com.jesusn.booking.booking_service.dtos.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.util.List;

public record BookingRequestDTO(
        @NotNull(message = "El ID del cliente es obligatorio")
        Integer customerId,

        @NotEmpty(message = "Debe seleccionar al menos un asiento")
        List<Integer> eventSeatIds) {
}
