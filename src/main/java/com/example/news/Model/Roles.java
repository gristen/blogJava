package com.example.news.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;


public enum Roles implements GrantedAuthority {
    ROLE_USER,ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}