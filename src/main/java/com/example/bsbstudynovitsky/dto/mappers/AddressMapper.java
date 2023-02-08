package com.example.bsbstudynovitsky.dto.mappers;

import com.example.bsbstudynovitsky.dto.AddressDTO;
import com.example.bsbstudynovitsky.entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO addressToAddressDTO(Address entity);

    Address addressDTOtoAddress(AddressDTO dto);

}
