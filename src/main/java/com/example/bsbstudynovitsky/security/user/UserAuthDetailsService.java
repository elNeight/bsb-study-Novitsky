package com.example.bsbstudynovitsky.security.user;

import com.example.bsbstudynovitsky.repositories.UserAuthDetailsRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserAuthDetailsService implements UserDetailsService {

    private final UserAuthDetailsRepository userAuthDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthDetailsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
