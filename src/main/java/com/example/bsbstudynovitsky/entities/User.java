package com.example.bsbstudynovitsky.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(of = {"firstname", "lastname", "phoneNumber", "email"}, callSuper = true)
public class User extends BasicIdAwareEntity {

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Document> documents;

}
