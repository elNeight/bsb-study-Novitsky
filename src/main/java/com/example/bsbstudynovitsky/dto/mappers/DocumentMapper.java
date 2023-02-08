package com.example.bsbstudynovitsky.dto.mappers;

import com.example.bsbstudynovitsky.dto.DocumentDTO;
import com.example.bsbstudynovitsky.entities.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    DocumentDTO documentTODocumentDTO(Document entity);

    Document documentDTOtoDocument(DocumentDTO dto);

}
