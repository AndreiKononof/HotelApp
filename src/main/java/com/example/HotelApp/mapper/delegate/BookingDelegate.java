package com.example.HotelApp.mapper.delegate;

import com.example.HotelApp.dto.request.BookingRequest;
import com.example.HotelApp.dto.response.BookingResponse;
import com.example.HotelApp.mapper.BookingMapper;
import com.example.HotelApp.model.Booking;
import com.example.HotelApp.service.interfaces.RoomService;
import com.example.HotelApp.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class BookingDelegate implements BookingMapper {

    private final UserService userService;

    private final RoomService roomService;

    @Override
    public Booking bookingRequestToBooking(BookingRequest bookingRequest) {
        Booking booking = new Booking();

        booking.setDateEntry(bookingRequest.getDateEntry());
        booking.setDateExit(bookingRequest.getDateExit());
        booking.setUser(userService.findById(bookingRequest.getUserId()));
        booking.setRoom(roomService.findById(bookingRequest.getRoomId()));

        return booking;
    }

    @Override
    public BookingResponse bookingToBookingResponse(Booking booking) {
        BookingResponse response = new BookingResponse();
        response.setDateEntry(booking.getDateEntry());
        response.setDateExit(booking.getDateExit());
        response.setRoomName(booking.getRoom().getName());
        response.setUserName(booking.getUser().getName());
        return response;
    }
}
