package com.example.HotelApp.service.interfaces;


import com.example.HotelApp.dto.response.pagination.PageInfo;
import com.example.HotelApp.model.Hotel;

import java.util.List;

public interface HotelService {

    Hotel save(Hotel hotel);

    Hotel update(Hotel hotel);

    List<Hotel> findAll(PageInfo pageInfo);

    Hotel findById(Long id);

    void deleteById(Long id);

}
