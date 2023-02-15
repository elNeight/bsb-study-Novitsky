package com.example.bsbstudynovitsky.entities.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public enum Role {

    USER(Set.of(Authority.READ));

    private Set<? extends GrantedAuthority> authorities;

    Role(Set<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Set<? extends GrantedAuthority> authorities() {
        return authorities;
    }

}
