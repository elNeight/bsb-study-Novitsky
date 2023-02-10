package com.example.bsbstudynovitsky.entities;

import jakarta.persistence.*;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    private User user;

}
