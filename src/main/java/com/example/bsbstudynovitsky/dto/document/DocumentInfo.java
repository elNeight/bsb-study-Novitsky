package com.example.bsbstudynovitsky.dto.document;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DocumentInfo {

    @NotEmpty(message = "title shouldn't be empty")
    @Size(min = 1, message = "document title should be at least 1 character")
    private String title;

    @NotEmpty(message = "content type shouldn't be empty")
    @Size(min = 1)
    private String contentType;

}
