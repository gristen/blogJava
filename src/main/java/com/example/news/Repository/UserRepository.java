package com.example.news.Repository;

import com.example.news.Model.Posts;
import com.example.news.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
