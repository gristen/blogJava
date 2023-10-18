package com.example.news.Controller;

import com.example.news.Model.Posts;
import com.example.news.Model.User;
import com.example.news.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class UserController {

    private  final UserService userService;
    @GetMapping("/register")
    public String loadPage(Model model){
        model.addAttribute("user", new User());


        return "reg";

    }

    @PostMapping("/register/save")
    public String register(@ModelAttribute User user){
        userService.save(user);

        return "index";

    }



}
