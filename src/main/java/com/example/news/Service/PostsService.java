package com.example.news.Service;

import com.example.news.Model.Posts;
import com.example.news.Model.User;
import com.example.news.Repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostsService {


    private final PostsRepository postRepository;

    // СОХРАНЕНИЕ
    public Posts save(Posts post){
        return postRepository.save(post);
    }


    // УДАЛЕНИЕ
    public void delete(Long id){
        this.postRepository.deleteById(id);
    }


    //ПОИСК ПО ID
    public Optional<Posts> getById(Long id){
        return postRepository.findById(id);
    }



    public List<Posts> getAllPosts(){
        return postRepository.findAll();
    }
}
