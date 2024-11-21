package com.example.HotelApp.service;


import com.example.HotelApp.dto.response.pagination.PageInfo;
import com.example.HotelApp.exception.NotFoundException;
import com.example.HotelApp.model.Room;
import com.example.HotelApp.repository.RoomRepository;
import com.example.HotelApp.service.interfaces.HotelService;
import com.example.HotelApp.service.interfaces.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Room save(Room room) {
        Room saveRoom = roomRepository.save(room);
        log.info("Сохранена комната name - {0}, ID -{1}, в отеле ID - {2}",
                saveRoom.getName(), saveRoom.getId(), saveRoom.getHotel().getId());
        return saveRoom;
    }

    @Override
    public Room update(Room room) {
        Room updateRoom = roomRepository.save(room);
        log.info("Обновлена комната name - {0}, ID -{1}, в отеле ID - {2}",
                updateRoom.getName(), updateRoom.getId(), updateRoom.getHotel().getId());
        return updateRoom;
    }

    @Override
    public Room findById(Long id) {
        Room room = roomRepository
                .findById(id)
                .orElseThrow(()
                        -> new NotFoundException(MessageFormat.format("Комната с ID - {} не найдена", id)));
        log.info("Найдена комната с ID - {}",id);
        return room;
    }

    @Override
    public List<Room> findAll(Long hotelId, PageInfo pageInfo) {
        List<Room> rooms = roomRepository
                .findAllWhereHotelId(hotelId, PageRequest.of(pageInfo.getPage(), pageInfo.getSize()));
        log.info("Запрошен список комнат отеля ID {0}", hotelId);
        return rooms;
    }

    @Override
    public List<Room> findAll(Long hotelId) {
        List<Room> rooms = roomRepository.findAllWhereHotelId(hotelId);
        log.info("Запрошен список комнат отеля ID {0} без пагинации", hotelId);
        return rooms;
    }

    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
        log.info("Удалена комната ID - {0}", id);
    }
}
