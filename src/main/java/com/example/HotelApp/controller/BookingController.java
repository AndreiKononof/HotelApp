package com.example.HotelApp.controller;


import com.example.HotelApp.dto.request.BookingRequest;
import com.example.HotelApp.dto.response.BookingResponse;
import com.example.HotelApp.dto.response.responseList.BookingListResponse;
import com.example.HotelApp.dto.utilDtoClass.BookingHotelRequest;
import com.example.HotelApp.dto.utilDtoClass.BookingUserRequest;
import com.example.HotelApp.mapper.BookingMapper;
import com.example.HotelApp.model.Booking;
import com.example.HotelApp.service.interfaces.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    private final BookingMapper bookingMapper;

    @PutMapping()
    public ResponseEntity<BookingResponse> bookingRoom (@Valid @RequestBody BookingRequest bookingRequest){
        log.info("Запрос: Бцронирование комнаты {0} пользователем {0}", bookingRequest.getRoomId(), bookingRequest.getUserId() );
        Booking booking = bookingService.bookingRoom(bookingMapper.bookingRequestToBooking(bookingRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingMapper.bookingToBookingResponse(booking));
    }

    @GetMapping("/user")
    public ResponseEntity<BookingListResponse> getAllUser (@Valid BookingUserRequest userRequest){
        log.info("Запрос: Список бронирования пользователя {}",userRequest.getNameUser());
        List<Booking> bookings = bookingService.findAll(userRequest.getNameUser());
        return ResponseEntity.status(HttpStatus.OK).body(bookingMapper.bookingListToBookingListResponse(bookings));
    }
    @GetMapping("/hotel")
    public ResponseEntity<BookingListResponse> getAllHotel (@Valid BookingHotelRequest hotelRequest){
        log.info("Запрос: Список бронирования отеля {}",hotelRequest.getHotelId());
        List<Booking> bookings = bookingService.findAll(hotelRequest.getHotelId());
        return ResponseEntity.status(HttpStatus.OK).body(bookingMapper.bookingListToBookingListResponse(bookings));
    }

}
