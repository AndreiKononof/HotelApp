package com.example.HotelApp.service;

import com.example.HotelApp.exception.NotFoundException;
import com.example.HotelApp.model.Hotel;
import com.example.HotelApp.repository.HotelRepository;
import com.example.HotelApp.service.interfaces.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        log.info("Save hotel name - {0}, ID - {1}", saveHotel.getName(), saveHotel.getId());
        return saveHotel;
    }

    @Override
    public Hotel update(Hotel hotel) {
        Hotel updateHotel = hotelRepository
                .findById(hotel.getId())
                .orElseThrow(()
                        -> new NotFoundException(MessageFormat.format("Отель с ID - {} не найден", hotel.getId())));
        hotelRepository.save(updateHotel);
        log.info("Update hotel name - {0}, ID - {1}", updateHotel.getName(), updateHotel.getId());
        return updateHotel;
    }

    @Override
    public List<Hotel> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        log.info("Find all hotel");
        return hotels;
    }

    @Override
    public Hotel findById(Long id) {


        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
