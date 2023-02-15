package com.example.bsbstudynovitsky.dto.mappers.user;

import com.example.bsbstudynovitsky.dto.user.UserInfo;
import com.example.bsbstudynovitsky.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserInfo userToUserDTO(User entity);

    public abstract List<UserInfo> mapList(List<User> entities);


}
