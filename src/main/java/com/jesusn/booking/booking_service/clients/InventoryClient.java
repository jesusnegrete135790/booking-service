package com.jesusn.booking.booking_service.clients;

import com.jesusn.booking.booking_service.dtos.external.EventSeatDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "inventory-service", url = "http://localhost:8080")
public interface InventoryClient {

    @GetMapping("/api/v1/event-seats/{id}")
    EventSeatDTO getEventSeatById(@PathVariable("id") Integer id);

}