package com.example.bsbstudynovitsky.dto.mappers.document;

import com.example.bsbstudynovitsky.dto.document.DocumentDTO;
import com.example.bsbstudynovitsky.entities.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    DocumentDTO documentTODocumentDTO(Document entity);

    Document documentDTOtoDocument(DocumentDTO dto);

}
