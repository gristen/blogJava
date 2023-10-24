package com.example.news.Model;


import lombok.Data;

import javax.persistence.*;


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
    private String image = "Заглушка";


    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;



}
