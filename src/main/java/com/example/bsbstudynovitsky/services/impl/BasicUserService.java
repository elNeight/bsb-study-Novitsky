package com.example.bsbstudynovitsky.services.impl;

import com.example.bsbstudynovitsky.entities.User;
import com.example.bsbstudynovitsky.repositories.UserRepository;
import com.example.bsbstudynovitsky.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasicUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User dbUser = userRepository.findById(id).orElseThrow();
        user.setId(dbUser.getId());
        user.setCreatedAt(dbUser.getCreatedAt());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
