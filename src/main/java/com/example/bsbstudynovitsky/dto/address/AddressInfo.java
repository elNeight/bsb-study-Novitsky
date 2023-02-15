package com.example.bsbstudynovitsky.dto.address;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressInfo {

    @NotEmpty(message = "street shouldn't be empty")
    @Size(min = 2, message = "street should be at least 2 characters")
    private String street;

    @NotEmpty(message = "city shouldn't be empty")
    @Size(min = 2, message = "city should be at least 2 characters")
    private String city;

    @NotEmpty(message = "zipcode shouldn't be empty")
    @Pattern(regexp = "\\d{6}", message = "wrong zipcode format")
    private String zipcode;

}
