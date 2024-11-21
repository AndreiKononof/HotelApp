package com.example.HotelApp.repository;

import com.example.HotelApp.model.Booking;
import com.example.HotelApp.model.Room;
import com.example.HotelApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {

    List<Booking> findAllWhereUser (User user);
    List<Booking> findAllWhereRoom (Room room);
}
