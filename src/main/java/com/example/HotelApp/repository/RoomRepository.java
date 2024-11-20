package com.example.HotelApp.repository;

import com.example.HotelApp.model.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long>, JpaSpecificationExecutor<Room> {

    List<Room> findAllWhereHotelId (Long hotelId, Pageable pageable);
}
