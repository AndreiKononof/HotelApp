package com.example.HotelApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title = null;

    @Column(name = "town")
    private String town;

    @Column(name = "address")
    private String address;

    @Column(name = "distance_center")
    private Double distanceToCenter;

    @Column(name = "rating")
    private Double rating = null;

    @Column(name = "count_ratings")
    private Integer countRatings = null;

    @CreationTimestamp
    @Column(name = "create_time")
    private Instant createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Instant updateTime;


}
