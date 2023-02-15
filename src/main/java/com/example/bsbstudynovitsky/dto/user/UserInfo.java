package com.example.bsbstudynovitsky.dto.user;

import com.example.bsbstudynovitsky.dto.address.AddressInfo;
import com.example.bsbstudynovitsky.dto.document.DocumentInfo;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

    private List<AddressInfo> addresses;
    private List<DocumentInfo> documents;

}
