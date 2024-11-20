package com.example.HotelApp.service.interfaces;


import com.example.HotelApp.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User create(User User);

    User update(User user);

    User findByName(String name);

    User findById(Long id);

    User findByNameAndEmail(String name, String email);

    List<User> findAll();

    void delete(Long id);
}
