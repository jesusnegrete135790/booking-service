package com.jesusn.booking.booking_service.controllers;

import com.jesusn.booking.booking_service.dtos.request.CustomerRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.CustomerResponseDTO;
import com.jesusn.booking.booking_service.services.CustomerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO>getCustomerById(@Valid @PathVariable Integer id){
        return ResponseEntity.ok(customerService.getCustomerById(id)) ;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>>getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO>createCustomer(@Valid @RequestBody CustomerRequestDTO request){
        CustomerResponseDTO customerResponseDTO =customerService.createCustomer(request);
        return new ResponseEntity<>(customerResponseDTO,HttpStatus.CREATED);
    }

}
