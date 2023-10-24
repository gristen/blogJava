package com.example.news.Service;

import com.example.news.Model.Roles;
import com.example.news.Model.User;
import com.example.news.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user)
    {
        System.out.println("DDDDDD"+user.getUsername());
        String username = user.getUsername();
        if (userRepository.findByUsername(username)!=null)  return false;

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Roles.ROLE_USER);
        userRepository.save(user);
        return true;
    }

}
