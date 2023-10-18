package com.example.news.Service;

import com.example.news.Model.User;
import com.example.news.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // СОХРАНЕНИЕ
    public User save(User user){
        return userRepository.save(user);
    }


    // УДАЛЕНИЕ
    public void delete(Long id){
        this.userRepository.deleteById(id);
    }


    //ПОИСК ПО ID
    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }



    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
