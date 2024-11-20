package com.example.HotelApp.mapper;


import com.example.HotelApp.dto.request.RoomRequest;
import com.example.HotelApp.dto.response.RoomListResponse;
import com.example.HotelApp.dto.response.RoomResponse;
import com.example.HotelApp.mapper.delegate.RoomDelegate;
import com.example.HotelApp.model.Room;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(RoomDelegate.class)
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {


    Room roomRequestToRoom(RoomRequest roomRequest);

    Room roomRequestToRoom(Long id, RoomRequest roomRequest);

    RoomResponse roomToRoomResponse(Room room);

    List<RoomResponse> roomListToListResponse(List<Room> rooms);

    default RoomListResponse roomListToRoomListResponse(List<Room> rooms){
        RoomListResponse response = new RoomListResponse();
        response.setRoomResponseList(roomListToListResponse(rooms));
        return response;
    }

}
