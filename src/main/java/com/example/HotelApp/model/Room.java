package com.example.HotelApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "number")
    private Integer number;

    @Column(name = "price")
    private Double price;

    @Column(name = "max_count_people")
    private Integer maxCountPeople;

    @Column(name = "booking_now")
    private List<Instant> bookedNow = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @CreationTimestamp
    @Column(name = "create_time")
    private Instant createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Instant updateTime;

}
