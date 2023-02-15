package com.example.bsbstudynovitsky.dto.mappers.document;

import com.example.bsbstudynovitsky.dto.document.DocumentInfo;
import com.example.bsbstudynovitsky.entities.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    DocumentInfo documentTODocumentDTO(Document entity);

    Document documentDTOtoDocument(DocumentInfo dto);

}
