package com.example.HotelApp.mapper.delegate;

import com.example.HotelApp.dto.request.HotelRequest;
import com.example.HotelApp.exception.NotFoundException;
import com.example.HotelApp.mapper.HotelMapper;
import com.example.HotelApp.model.Hotel;
import com.example.HotelApp.service.interfaces.HotelService;
import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;

@RequiredArgsConstructor
public abstract class HotelDelegate implements HotelMapper {

    private final HotelService hotelService;

    @Override
    public Hotel hotelRequestToHotel(Long hotelId, HotelRequest hotelRequest) {
        Hotel hotel = hotelService.findById(hotelId);
        if (hotel == null) {
            throw new NotFoundException(MessageFormat.format("Отель с ID - {} не нвйден", hotelId));
        }

        hotel.setName(hotelRequest.getName());
        hotel.setTown(hotelRequest.getTown());
        hotel.setAddress(hotelRequest.getAddress());
        hotel.setDistanceToCenter(hotelRequest.getDistanceToCenter());

        return hotel;
    }
}
