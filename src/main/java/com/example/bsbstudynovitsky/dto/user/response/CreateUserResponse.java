package com.example.bsbstudynovitsky.dto.user.response;

import com.example.bsbstudynovitsky.dto.address.AddressDTO;
import com.example.bsbstudynovitsky.dto.document.DocumentDTO;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserResponse {

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

    private List<AddressDTO> addresses;
    private List<DocumentDTO> documents;

}
