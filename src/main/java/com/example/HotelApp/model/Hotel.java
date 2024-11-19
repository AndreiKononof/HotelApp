package com.example.HotelApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "town")
    private String town;

    @Column(name = "address")
    private String address;

    @Column(name = "distance_center")
    private Double distanceToCenter;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "count_ratings")
    private Integer countRatings;


}
