package com.example.news.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long id;
    private String f_name;
    private String l_name;
    private String s_name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "id_role",columnDefinition = "INT DEFAULT 1")
    private Roles role;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Posts> posts;

    // Конструктор с установкой значения по умолчанию для id_role
    public User() {
        this.role = new Roles();
        this.role.setId_role(1L); // Устанавливаем значение по умолчанию
    }


}
