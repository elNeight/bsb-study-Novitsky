package com.example.bsbstudynovitsky.dto.mappers.user;

import com.example.bsbstudynovitsky.dto.user.request.CreateUserRequest;
import com.example.bsbstudynovitsky.dto.user.response.CreateUserResponse;
import com.example.bsbstudynovitsky.entities.Address;
import com.example.bsbstudynovitsky.entities.Document;
import com.example.bsbstudynovitsky.entities.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class CreateUserMapper {

    public abstract CreateUserResponse userToUserResponse(User entity);

    public abstract User userRequestToUser(CreateUserRequest dto);

    @AfterMapping
    protected void populateWithUser(@MappingTarget User entity) {

        List<Address> addresses = entity.getAddresses();
        List<Document> documents = entity.getDocuments();

        if (Objects.nonNull(addresses))
            entity.getAddresses().forEach(address -> address.setUser(entity));

        if (Objects.nonNull(documents))
            entity.getDocuments().forEach(document -> document.setUser(entity));

    }

    @AfterMapping
    protected void checkForNull(@MappingTarget CreateUserResponse dto) {

        if (Objects.isNull(dto.getDocuments()))
            dto.setDocuments(Collections.emptyList());

        if (Objects.isNull(dto.getAddresses()))
            dto.setAddresses(Collections.emptyList());

    }

}
