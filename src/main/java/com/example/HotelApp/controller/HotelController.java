package com.example.HotelApp.controller;


import com.example.HotelApp.dto.request.HotelRequest;
import com.example.HotelApp.dto.response.responseList.HotelListResponse;
import com.example.HotelApp.dto.response.HotelResponse;
import com.example.HotelApp.dto.response.pagination.PageInfo;
import com.example.HotelApp.mapper.HotelMapper;
import com.example.HotelApp.model.Hotel;
import com.example.HotelApp.service.interfaces.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    private final HotelMapper hotelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getById(@PathVariable Long id) {
        log.info("Запрос: Отель с ID - {}", id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(hotelMapper.hotelToHotelResponse(hotelService.findById(id)));
    }

    @GetMapping()
    public ResponseEntity<HotelListResponse> getAll(@Valid PageInfo pageInfo) {
        log.info("Запрос: Список отелей");
        return ResponseEntity.status(HttpStatus.OK)
                .body(hotelMapper.hotelListToHotelListResponse(hotelService.findAll(pageInfo)));
    }

    @PostMapping
    public ResponseEntity<HotelResponse> create(@Valid @RequestBody HotelRequest hotelRequest) {
        log.info("Запрос: Создание отеля {}", hotelRequest);
        Hotel hotel = hotelService.save(hotelMapper.hotelRequestToHotel(hotelRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelMapper.hotelToHotelResponse(hotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponse> update(@PathVariable Long id, @Valid HotelRequest hotelRequest) {
        log.info("Запрос: Изменения отеля с ID {}", id);
        Hotel hotel = hotelService.update(hotelMapper.hotelRequestToHotel(id, hotelRequest));
        return ResponseEntity.status(HttpStatus.OK).body(hotelMapper.hotelToHotelResponse(hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Запрос: Удаление отеля с ID {}", id);
        hotelService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
