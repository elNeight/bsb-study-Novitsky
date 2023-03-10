package com.example.bsbstudynovitsky.dto.user.request;

import com.example.bsbstudynovitsky.dto.address.AddressInfo;
import com.example.bsbstudynovitsky.dto.document.DocumentInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserRequest {

    @NotEmpty(message = "firstname shouldn't be empty")
    @Size(min = 2, message = "firstname should be at least 2 characters")
    private String firstname;

    @NotEmpty(message = "lastname shouldn't be empty")
    @Size(min = 2, message = "lastname should be at least 2 characters")
    private String lastname;

    @NotEmpty(message = "phone number shouldn't be empty")
    @Pattern(regexp = "\\+375(23|25|29|33|44)\\d{7}", message = "wrong phone number format")
    private String phoneNumber;

    @NotEmpty(message = "email shouldn't be empty")
    @Email(message = "wrong email format")
    private String email;

    @Valid
    private List<AddressInfo> addresses;
    @Valid
    private List<DocumentInfo> documents;

}
