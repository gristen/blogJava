package com.example.news.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "role")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    private String name;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role" )
    private List<User> users;
}
