package com.example.HotelApp.model;

import com.example.HotelApp.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "ENUM")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Booking> bookings;

    @CreationTimestamp
    @Column(name = "create_time")
    @ToString.Include
    private Instant createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    @ToString.Include
    private Instant updateTime;


}
