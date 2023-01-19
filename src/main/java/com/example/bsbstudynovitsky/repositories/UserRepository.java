package com.example.bsbstudynovitsky.repositories;

import com.example.bsbstudynovitsky.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
