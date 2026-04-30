package com.jesusn.booking.booking_service.repositories;

import com.jesusn.booking.booking_service.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    List<Booking> findByCustomerId(Integer id);
}
