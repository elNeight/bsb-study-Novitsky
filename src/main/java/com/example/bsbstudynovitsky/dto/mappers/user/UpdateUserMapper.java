package com.example.bsbstudynovitsky.dto.mappers.user;

import com.example.bsbstudynovitsky.dto.user.request.UpdateUserRequest;
import com.example.bsbstudynovitsky.dto.user.response.UpdateUserResponse;
import com.example.bsbstudynovitsky.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper {

    UpdateUserResponse userToUserResponse(User entity);

    User userRequestToUser(UpdateUserRequest dto);

}
