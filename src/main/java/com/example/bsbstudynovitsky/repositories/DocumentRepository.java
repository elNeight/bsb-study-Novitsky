package com.example.bsbstudynovitsky.repositories;

import com.example.bsbstudynovitsky.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {}
