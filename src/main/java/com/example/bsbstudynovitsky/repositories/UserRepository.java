package com.example.bsbstudynovitsky.repositories;

import com.example.bsbstudynovitsky.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
