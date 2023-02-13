package com.example.bsbstudynovitsky.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void addAddress(Address address) {

        if (Objects.isNull(addresses))
            addresses = new ArrayList<>();

        addresses.add(address);
        address.setUser(this);

    }

    public void addDocument(Document document) {

        if (Objects.isNull(documents))
            documents = new ArrayList<>();

        documents.add(document);
        document.setUser(this);

    }

}
