package com.jesusn.booking.booking_service.repositories;

import com.jesusn.booking.booking_service.entities.BookingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingItemRepository extends JpaRepository<BookingItem,Integer> {
}
