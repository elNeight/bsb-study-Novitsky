package com.example.bsbstudynovitsky.services.impl;

import com.example.bsbstudynovitsky.entities.User;
import com.example.bsbstudynovitsky.repositories.UserRepository;
import com.example.bsbstudynovitsky.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BasicUserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void save() {

        User user = new User();
        user.setFirstname("Ivan");
        when(userRepository.save(user)).thenReturn(user);

        User dbUser = userService.save(user);

        assertThat(dbUser.getFirstname()).isSameAs(user.getFirstname());
        verify(userRepository).save(user);

    }

    @Test
    void findAll() {

        User first = new User();
        first.setFirstname("Ivan");
        User second = new User();
        second.setFirstname("Vladimir");
        when(userRepository.findAll()).thenReturn(List.of(first, second));

        Iterable<User> all = userService.findAll();
        List<User> users = new ArrayList<>();
        all.forEach(users::add);

        assertThat(users.size()).isSameAs(2);
        verify(userRepository).findAll();

    }

    @Test
    void findById() {

        Long id = 1L;
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        User dbUser = userService.findById(id);

        assertThat(dbUser.getId()).isSameAs(id);
        verify(userRepository).findById(id);

    }

    @Test
    void update() {

        Long id = 1L;
        User user = new User();
        user.setId(id);
        user.setFirstname("Ivan");
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        User dbUser = userService.update(id, user);

        assertThat(dbUser.getFirstname()).isSameAs(user.getFirstname());
        verify(userRepository).save(user);

    }

    @Test
    void deleteById() {

        Long id = 1L;
        User user = new User();
        user.setId(1L);
        willDoNothing().given(userRepository).deleteById(id);

        userService.deleteById(id);

        verify(userRepository).deleteById(id);

    }
}