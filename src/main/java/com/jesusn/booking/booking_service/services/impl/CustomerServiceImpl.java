package com.jesusn.booking.booking_service.services.impl;

import com.jesusn.booking.booking_service.dtos.request.CustomerRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.CustomerResponseDTO;
import com.jesusn.booking.booking_service.entities.Customer;
import com.jesusn.booking.booking_service.mappers.CustomerMapper;
import com.jesusn.booking.booking_service.repositories.CustomerRepository;
import com.jesusn.booking.booking_service.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO request) {
        Customer customer = customerMapper.toEntity(request);

        customerRepository.save(customer);

        return customerMapper.toDto(customer);
    }

    @Override
    public CustomerResponseDTO getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el cliente con ID: " + id));

        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerMapper.toDtoList(customerRepository.findAll());
    }
}
