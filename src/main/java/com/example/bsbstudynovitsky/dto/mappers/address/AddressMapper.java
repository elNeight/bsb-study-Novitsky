package com.example.bsbstudynovitsky.dto.mappers.address;

import com.example.bsbstudynovitsky.dto.address.AddressInfo;
import com.example.bsbstudynovitsky.entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressInfo addressToAddressDTO(Address entity);

    Address addressDTOtoAddress(AddressInfo dto);

}
