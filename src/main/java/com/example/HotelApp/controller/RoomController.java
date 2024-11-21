package com.example.HotelApp.controller;

import com.example.HotelApp.dto.request.RoomRequest;
import com.example.HotelApp.dto.response.RoomResponse;
import com.example.HotelApp.mapper.RoomMapper;
import com.example.HotelApp.model.Room;
import com.example.HotelApp.service.interfaces.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    private final RoomMapper roomMapper;


    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getById(@PathVariable Long id) {
        log.info("Запрос: Комната с ID - {0}", id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(roomMapper.roomToRoomResponse(roomService.findById(id)));
    }

//    @GetMapping("/all/{id}")
//    public ResponseEntity<RoomListResponse> getAll(@PathVariable Long hotelId, @Valid PageInfo pageInfo){
//        log.info("Запрос: Список комнат отеля с ID - {0}", hotelId);
//        List<Room> rooms = roomService.findAll(hotelId,pageInfo);
//        return ResponseEntity.status(HttpStatus.OK).body(roomMapper.roomListToRoomListResponse(rooms));
//    }

    @PostMapping()
    public ResponseEntity<RoomResponse> create(@Valid @RequestBody RoomRequest roomRequest) {
        log.info("Запрос: Создание комнаты {}", roomRequest);
        Room createRoom = roomService.save(roomMapper.roomRequestToRoom(roomRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(roomMapper.roomToRoomResponse(createRoom));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> update(@PathVariable Long id, @Valid @RequestBody RoomRequest roomRequest) {
        log.info("Запрос: Обновление комнаты с ID - {}", id);
        Room updateRoom = roomService.update(roomMapper.roomRequestToRoom(id, roomRequest));
        return ResponseEntity.status(HttpStatus.OK).body(roomMapper.roomToRoomResponse(updateRoom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        log.info("Запрос: Удаление комнаты с ID - {}", id);
        roomService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
