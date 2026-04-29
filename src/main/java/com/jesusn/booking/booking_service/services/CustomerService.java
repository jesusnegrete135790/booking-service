package com.jesusn.booking.booking_service.services;

import com.jesusn.booking.booking_service.dtos.request.CustomerRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO request);

    CustomerResponseDTO getCustomerById(Integer id);

    List<CustomerResponseDTO> getAllCustomers();
}
