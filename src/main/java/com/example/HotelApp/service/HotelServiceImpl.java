package com.example.HotelApp.service;

import com.example.HotelApp.dto.response.pagination.PageInfo;
import com.example.HotelApp.exception.NotFoundException;
import com.example.HotelApp.model.Hotel;
import com.example.HotelApp.repository.HotelRepository;
import com.example.HotelApp.service.interfaces.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;


    @Override
    public Hotel save(Hotel hotel) {
        Hotel saveHotel = hotelRepository.save(hotel);
        log.info("Сохранен отель - {0}, ID - {1}", saveHotel.getName(), saveHotel.getId());
        return saveHotel;
    }

    @Override
    public Hotel update(Hotel hotel) {
        hotelRepository.save(hotel);
        log.info("Обновлены данные отеля - {0}, ID - {1}", hotel.getName(), hotel.getId());
        return hotel;
    }

    @Override
    public List<Hotel> findAll(PageInfo pageInfo) {
        List<Hotel> hotels = hotelRepository.findAll(PageRequest.of(pageInfo.getPage(), pageInfo.getSize())).getContent();
        log.info("Выполнен запрос списка отелей");
        return hotels;
    }

    @Override
    public Hotel findById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()
                -> new NotFoundException(MessageFormat.format("Отель с ID - {} не найден", id)));
        log.info("Найден отель с ID - {}", id);
        return hotel;
    }

    @Override
    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
        log.info("Удален отель с ID - {}", id);
    }
}
