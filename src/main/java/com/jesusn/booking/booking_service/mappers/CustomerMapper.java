package com.jesusn.booking.booking_service.mappers;

import com.jesusn.booking.booking_service.dtos.request.CustomerRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.CustomerResponseDTO;
import com.jesusn.booking.booking_service.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequestDTO requestDTO);
    CustomerResponseDTO toDto(Customer entity);
}
