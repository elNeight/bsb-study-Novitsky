package com.example.bsbstudynovitsky.dto.mappers.user;

import com.example.bsbstudynovitsky.dto.user.UserDTO;
import com.example.bsbstudynovitsky.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserDTO userToUserDTO(User entity);

    public abstract List<UserDTO> mapList(List<User> entities);


}
