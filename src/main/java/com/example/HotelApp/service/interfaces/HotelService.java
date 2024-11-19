package com.example.HotelApp.service.interfaces;


import com.example.HotelApp.model.Hotel;

import java.util.List;

public interface HotelService {

    Hotel save(Hotel hotel);

    Hotel update(Hotel hotel);

    List<Hotel> findAll();

    Hotel findById(Long id);

    void deleteById(Long id);

}