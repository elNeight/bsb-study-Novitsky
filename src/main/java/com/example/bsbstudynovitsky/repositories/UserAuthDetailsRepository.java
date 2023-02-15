package com.example.bsbstudynovitsky.repositories;

import com.example.bsbstudynovitsky.entities.security.UserAuthDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthDetailsRepository extends JpaRepository<UserAuthDetails, Long> {

    Optional<UserAuthDetails> findByUsername(String username);

}
