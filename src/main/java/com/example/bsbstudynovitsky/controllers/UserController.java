package com.example.bsbstudynovitsky.controllers;

import com.example.bsbstudynovitsky.dto.mappers.user.CreateUserMapper;
import com.example.bsbstudynovitsky.dto.mappers.user.UpdateUserMapper;
import com.example.bsbstudynovitsky.dto.mappers.user.UserMapper;
import com.example.bsbstudynovitsky.dto.user.UserDTO;
import com.example.bsbstudynovitsky.dto.user.request.CreateUserRequest;
import com.example.bsbstudynovitsky.dto.user.request.UpdateUserRequest;
import com.example.bsbstudynovitsky.dto.user.response.CreateUserResponse;
import com.example.bsbstudynovitsky.dto.user.response.UpdateUserResponse;
import com.example.bsbstudynovitsky.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final CreateUserMapper createUserMapper;
    private final UpdateUserMapper updateUserMapper;

    @GetMapping
    public List<UserDTO> findAll() {
        return userMapper.mapList(userService.findAll());
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userMapper.userToUserDTO(userService.findById(id));
    }

    @PostMapping
    public CreateUserResponse save(@Valid @RequestBody CreateUserRequest request) {
        return createUserMapper.userToUserResponse(userService.save(createUserMapper.userRequestToUser(request)));
    }

    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        return updateUserMapper.userToUserResponse(userService.update(id, updateUserMapper.userRequestToUser(request)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
