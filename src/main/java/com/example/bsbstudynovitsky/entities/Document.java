package com.example.bsbstudynovitsky.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "documents")
@EqualsAndHashCode(of = {"title"}, callSuper = true)
public class Document extends BasicIdAwareEntity {

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
