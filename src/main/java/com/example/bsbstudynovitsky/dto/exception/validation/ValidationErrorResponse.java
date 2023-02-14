package com.example.bsbstudynovitsky.dto.exception.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ValidationErrorResponse {

    private List<Violation> violations;

}
