package com.example.bsbstudynovitsky.controllers;

import com.example.bsbstudynovitsky.dto.UserDTO;
import com.example.bsbstudynovitsky.dto.mappers.UserMapper;
import com.example.bsbstudynovitsky.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDTO> findAll() {
        return userMapper.mapList(userService.findAll());
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userMapper.userToUserDTO(userService.findById(id));
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO user) {
        return userMapper.userToUserDTO(userService.save(userMapper.userDTOtoUser(user)));
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO user) {
        return userMapper.userToUserDTO(userService.update(id, userMapper.userDTOtoUser(user)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
