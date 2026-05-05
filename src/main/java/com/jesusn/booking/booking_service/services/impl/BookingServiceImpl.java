package com.jesusn.booking.booking_service.services.impl;

import com.jesusn.booking.booking_service.clients.InventoryClient;
import com.jesusn.booking.booking_service.dtos.external.EventSeatDTO;
import com.jesusn.booking.booking_service.dtos.request.BookingRequestDTO;
import com.jesusn.booking.booking_service.dtos.response.BookingResponseDTO;
import com.jesusn.booking.booking_service.entities.Booking;
import com.jesusn.booking.booking_service.entities.BookingItem;
import com.jesusn.booking.booking_service.entities.Customer;
import com.jesusn.booking.booking_service.mappers.BookingMapper;
import com.jesusn.booking.booking_service.repositories.BookingRepository;
import com.jesusn.booking.booking_service.repositories.CustomerRepository;
import com.jesusn.booking.booking_service.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final InventoryClient inventoryClient;
    private final BookingMapper bookingMapper;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    @Transactional
    public BookingResponseDTO createBooking(BookingRequestDTO request) {

        Customer customer = customerRepository.findById(request.customerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + request.customerId()));

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setBookingDate(LocalDateTime.now());
        booking.setStatus("CONFIRMED");

        BigDecimal totalAmount = BigDecimal.ZERO;


        for (Integer seatId : request.eventSeatIds()) {


            EventSeatDTO seatInfo = inventoryClient.getEventSeatById(seatId);


            BookingItem item = new BookingItem();
            item.setEventSeatId(seatId);
            item.setPrice(seatInfo.price());

            booking.addBookingItem(item);


            totalAmount = totalAmount.add(seatInfo.price());
        }

        booking.setTotalAmount(totalAmount);

        Booking savedBooking = bookingRepository.save(booking);

        kafkaTemplate.send("booking-events", savedBooking);
        return bookingMapper.toDto(savedBooking);
    }

    @Override
    @Transactional(readOnly = true)
    public BookingResponseDTO getBookingById(Integer id) {
        Booking booking =bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no encontrado"));

        kafkaTemplate.send("booking-events", bookingMapper.toDto(booking));
        return bookingMapper.toDto(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponseDTO> getBookingsByCustomerId(Integer customerId) {
        List<Booking> bookings =bookingRepository.findByCustomerId(customerId);
        kafkaTemplate.send("booking-events", bookingMapper.toDtoList(bookings));
        return bookingMapper.toDtoList(bookings);
    }
}