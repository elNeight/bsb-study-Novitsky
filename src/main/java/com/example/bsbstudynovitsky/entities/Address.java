package com.example.bsbstudynovitsky.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "addresses")
@EqualsAndHashCode(of = {"street", "city", "zipcode"}, callSuper = true)
public class Address extends BasicIdAwareEntity {

    private String street;
    private String city;
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
