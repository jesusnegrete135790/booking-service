package com.jesusn.booking.booking_service.mappers;

import com.jesusn.booking.booking_service.dtos.response.BookingItemResponseDTO;
import com.jesusn.booking.booking_service.entities.BookingItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingItemMapper {
    BookingItemResponseDTO toDto(BookingItem entity);
    List<BookingItemResponseDTO> toDtoList(List<BookingItem> entities);
}
