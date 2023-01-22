package com.example.bsbstudynovitsky.services.impl;

import com.example.bsbstudynovitsky.entities.User;
import com.example.bsbstudynovitsky.services.UserService;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import io.zonky.test.db.shaded.com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureEmbeddedDatabase(refresh = AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_EACH_TEST_METHOD)
class BasicUserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    void save() {

        User user = new User();
        user.setFirstname("Ivan");
        user.setLastname("Ivanov");
        user.setPhoneNumber("+375 33 777 77 77");
        user.setEmail("ivan@gmail.com");

        userService.save(user);
        User dbUser = userService.findById(user.getId());

        assertEquals(user, dbUser);

    }

    @Test
    void findAll() {

        User ivan = new User();
        ivan.setFirstname("Ivan");
        ivan.setLastname("Ivanov");
        ivan.setPhoneNumber("+375 33 777 77 77");
        ivan.setEmail("ivan@gmail.com");

        User vladimir = new User();
        vladimir.setFirstname("Vladimir");
        vladimir.setLastname("Vladimirov");
        vladimir.setPhoneNumber("+375 33 555 55 55");
        vladimir.setEmail("valodia@gmail.com");


        userService.save(ivan);
        userService.save(vladimir);
        ImmutableList<User> users = ImmutableList.copyOf(userService.findAll());

        assertEquals(2, users.size());
        assertTrue(users.containsAll(List.of(ivan, vladimir)));

    }

    @Test
    void findById() {

        User user = new User();
        user.setFirstname("Ivan");
        user.setLastname("Ivanov");
        user.setPhoneNumber("+375 33 777 77 77");
        user.setEmail("ivan@gmail.com");

        User saved = userService.save(user);
        User retrieved = userService.findById(saved.getId());

        assertEquals(saved, retrieved);

    }

    @Test
    void update() {

        User user = new User();
        user.setFirstname("Ivan");
        user.setLastname("Ivanov");
        user.setPhoneNumber("+375 33 777 77 77");
        user.setEmail("ivan@gmail.com");

        User update = new User();
        update.setFirstname("Ivan");
        update.setLastname("Ivanov");
        update.setPhoneNumber("+375 33 555 55 55");
        update.setEmail("ivan777@gmail.com");

        userService.save(user);
        userService.update(user.getId(), update);
        User dbUser = userService.findById(user.getId());

        assertEquals(update, dbUser);


    }

    @Test
    void deleteById() {

        User user = new User();
        user.setFirstname("Ivan");
        user.setLastname("Ivanov");
        user.setPhoneNumber("+375 33 777 77 77");
        user.setEmail("ivan@gmail.com");

        userService.save(user);
        userService.deleteById(user.getId());

        assertThrows(NoSuchElementException.class,
                () -> userService.findById(user.getId()));

    }
}