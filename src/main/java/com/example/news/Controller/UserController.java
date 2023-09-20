package com.example.news.Controller;

import com.example.news.Model.Posts;
import com.example.news.Service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class UserController {

        private final PostsService postsService;

        @GetMapping("")

        public String getAllPosts(Model model){
            model.addAttribute("posts", postsService.getAllPosts());
            model.addAttribute("post", new Posts());

            return "index";

        }


    }


