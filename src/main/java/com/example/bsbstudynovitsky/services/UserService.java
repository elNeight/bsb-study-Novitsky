package com.example.bsbstudynovitsky.services;

import com.example.bsbstudynovitsky.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);

}
