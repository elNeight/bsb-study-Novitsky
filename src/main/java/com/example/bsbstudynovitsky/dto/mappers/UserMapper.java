package com.example.bsbstudynovitsky.dto.mappers;

import com.example.bsbstudynovitsky.dto.user.UserDTO;
import com.example.bsbstudynovitsky.entities.Address;
import com.example.bsbstudynovitsky.entities.Document;
import com.example.bsbstudynovitsky.entities.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserDTO userToUserDTO(User entity);

    public abstract User userDTOtoUser(UserDTO dto);

    public abstract List<UserDTO> mapList(List<User> entities);

    @AfterMapping
    protected void populateWithUser(@MappingTarget User entity) {

        List<Address> addresses = entity.getAddresses();
        List<Document> documents = entity.getDocuments();

        if (Objects.nonNull(addresses))
            entity.getAddresses().forEach(address -> address.setUser(entity));

        if (Objects.nonNull(documents))
            entity.getDocuments().forEach(document -> document.setUser(entity));

    }

}
