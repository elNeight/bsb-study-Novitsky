package com.example.bsbstudynovitsky.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "documents")
@EqualsAndHashCode(of = {"title", "contentType"}, callSuper = true)
public class Document extends BasicIdAwareEntity {

    private String title;
    private String contentType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    private User user;

}
