package com.example.HotelApp.service.interfaces;


import com.example.HotelApp.dto.response.pagination.PageInfo;
import com.example.HotelApp.model.Room;

import java.util.List;

public interface RoomService {

    Room save(Room room);

    Room update(Room room);

    Room findById(Long id);

    List<Room> findAll(Long hotelId, PageInfo pageInfo);

    List<Room> findAll(Long hotelId);

    void delete(Long id);

}
