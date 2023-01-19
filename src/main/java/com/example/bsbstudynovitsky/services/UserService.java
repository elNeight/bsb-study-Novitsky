package com.example.bsbstudynovitsky.services;

import com.example.bsbstudynovitsky.entities.User;

public interface UserService {

    Iterable<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);

}
