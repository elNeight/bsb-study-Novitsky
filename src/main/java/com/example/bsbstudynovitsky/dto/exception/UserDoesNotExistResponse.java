package com.example.bsbstudynovitsky.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDoesNotExistResponse {

    private String message;

}
