package com.example.HotelApp.service;

import com.example.HotelApp.exception.BookingDateException;
import com.example.HotelApp.model.Booking;
import com.example.HotelApp.model.Hotel;
import com.example.HotelApp.model.Room;
import com.example.HotelApp.model.User;
import com.example.HotelApp.repository.BookingRepository;
import com.example.HotelApp.service.interfaces.BookingService;
import com.example.HotelApp.service.interfaces.HotelService;
import com.example.HotelApp.service.interfaces.RoomService;
import com.example.HotelApp.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final RoomService roomService;

    private final UserService userService;


    @Override
    public Booking bookingRoom(Booking booking) {
        Room room = roomService.findById(booking.getRoom().getId());
        List<LocalDate> bookedNow = room.getBookedNow();

        List<LocalDate> bookingUser = booking.getDateEntry().datesUntil(booking.getDateExit()).toList();

        for (LocalDate localDate : bookingUser) {
            if (bookedNow.contains(localDate)) {
                throw new BookingDateException("Желаемы период дат уже забронирован. Выберите другой период!");
            }
        }

        bookedNow.addAll(bookingUser);
        room.setBookedNow(bookedNow);

        bookingRepository.save(booking);
        roomService.save(room);
        log.info("Забронирована комната {0} - {1} дата вьезда {2} , дата выезда {3}"
                , room.getId(), room.getName(), booking.getDateEntry(), booking.getDateExit());

        return booking;

    }

    @Override
    public List<Booking> findAll(String userName) {
        User user = userService.findByName(userName);
        List<Booking> bookingsUser = bookingRepository.findAllWhereUser(user);
        log.info("Предоставлен список бронирования пользователя {0} - {1}",user.getId(), user.getName());
        return bookingsUser;
    }

    @Override
    public List<Booking> findAll(Long hotelId) {
        List<Room> rooms = roomService.findAll(hotelId);
        List<Booking> bookingsHotel = new ArrayList<>();
        for (Room room : rooms){
            bookingsHotel.addAll(bookingRepository.findAllWhereRoom(room));
        }
        return bookingsHotel;
    }
}
