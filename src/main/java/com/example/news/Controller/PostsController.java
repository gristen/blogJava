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

public class PostsController {

        private final PostsService postsService;

        @GetMapping("")

        public String getAllPosts(Model model){
            model.addAttribute("posts", postsService.getAllPosts());
            model.addAttribute("post", new Posts());

            return "index";

        }
   @PostMapping("/admin/posts/save")
   public String savePost(@ModelAttribute Posts posts)
    {
        postsService.save(posts);
        return "redirect:/admin/posts/index";

    }

    @GetMapping("/admin/posts/index")

    public String loadAllPosts(Model model){
        model.addAttribute("posts", postsService.getAllPosts());
        model.addAttribute("post", new Posts());

        return "/admin/posts/index";

    }
    @GetMapping("/admin/posts/create")

    public String createPost(Model model){
        System.out.println("create");
        model.addAttribute("post", new Posts());
        return "/admin/posts/create";

    }


    }


