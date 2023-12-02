package com.example.news.Model;


import jakarta.persistence.*;
import lombok.Data;




@Entity
@Data
@Table(name = "posts")
public class Posts {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_posts")
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;



}
