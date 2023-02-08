package com.example.bsbstudynovitsky.dto.mappers;

import com.example.bsbstudynovitsky.dto.UserDTO;
import com.example.bsbstudynovitsky.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User entity);

    User userDTOtoUser(UserDTO dto);

    List<UserDTO> mapList(List<User> entities);

}
