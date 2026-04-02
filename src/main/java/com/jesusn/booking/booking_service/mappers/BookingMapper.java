package com.jesusn.booking.booking_service.mappers;

import com.jesusn.booking.booking_service.dtos.response.BookingResponseDTO;
import com.jesusn.booking.booking_service.entities.Booking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingResponseDTO toDto(Booking entity);
    List<BookingResponseDTO> toDtoList(List<Booking> entities);
}
