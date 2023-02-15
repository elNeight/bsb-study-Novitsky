package com.example.bsbstudynovitsky.entities.security;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {

    READ;

    @Override
    public String getAuthority() {
        return name();
    }

}
