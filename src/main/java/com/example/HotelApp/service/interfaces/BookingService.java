package com.example.HotelApp.service.interfaces;

import com.example.HotelApp.model.Booking;

import java.util.List;

public interface BookingService {

      Booking bookingRoom(Booking booking);

     List<Booking> findAll(String userName);

     List<Booking> findAll(Long hotelId);
}
