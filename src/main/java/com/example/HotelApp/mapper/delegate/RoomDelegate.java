package com.example.HotelApp.mapper.delegate;

import com.example.HotelApp.dto.request.RoomRequest;
import com.example.HotelApp.dto.response.RoomResponse;
import com.example.HotelApp.mapper.RoomMapper;
import com.example.HotelApp.model.Hotel;
import com.example.HotelApp.model.Room;
import com.example.HotelApp.service.interfaces.HotelService;
import com.example.HotelApp.service.interfaces.RoomService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RoomDelegate implements RoomMapper {

    private final HotelService hotelService;

    private final RoomService roomService;

    @Override
    public RoomResponse roomToRoomResponse(Room room) {

        RoomResponse response = new RoomResponse();
        response.setName(room.getName());
        response.setDescription(room.getDescription());
        response.setNumber(room.getNumber());
        response.setPrice(room.getPrice());
        response.setMaxCountPeople(room.getMaxCountPeople());
        response.setHotelName(hotelService.findById(room.getHotel().getId()).getName());

        return response;
    }

    @Override
    public Room roomRequestToRoom(RoomRequest roomRequest) {
        return setRoomFields(new Room(), roomRequest);
    }

    @Override
    public Room roomRequestToRoom(Long id, RoomRequest roomRequest) {
        Room room = roomService.findById(id);
        return setRoomFields(room,roomRequest);
    }

    private Room setRoomFields(Room room, RoomRequest roomRequest){
        Hotel hotel = hotelService.findById(roomRequest.getHotelId());

        room.setName(roomRequest.getName());
        room.setDescription(roomRequest.getDescription());
        room.setNumber(roomRequest.getNumber());
        room.setPrice(roomRequest.getPrice());
        room.setMaxCountPeople(roomRequest.getMaxCountPeople());
        room.setHotel(hotel);
        return room;
    }

}
