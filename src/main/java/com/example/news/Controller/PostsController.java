package com.example.news.Controller;

import com.example.news.Model.Posts;
import com.example.news.Repository.UserRepository;
import com.example.news.Service.PostsService;
import com.example.news.Service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.news.Model.User;

@Controller
@RequiredArgsConstructor
@RequestMapping("")

public class PostsController {

        private final PostsService postsService;
        private final UserService userService;
        private final UserRepository userRepository;

        @GetMapping("")

        public String getAllPosts(Model model){
            model.addAttribute("posts", postsService.getAllPosts());
            model.addAttribute("post", new Posts());

            return "index";

        }
   @PostMapping("/admin/posts/save")
   public String savePost(@ModelAttribute Posts posts) {
            String title = posts.getTitle();
            String content = posts.getContent();
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

       if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
           // Получите UserDetails из Authentication
           UserDetails userDetails = (UserDetails) authentication.getPrincipal();

           // Получите имя (или другой идентификатор) пользователя
           String currentUsername = userDetails.getUsername();

           // Найдите пользователя в базе данных по имени (или другому идентификатору)
           User currentUser = userRepository.findByUsername(currentUsername);

           if (currentUser != null) {
               // Создайте новый объект Posts
               Posts newPost = new Posts();
               newPost.setTitle(title);
               newPost.setContent(content);

               // Установите текущего пользователя в объекте Posts
               newPost.setUser(currentUser);

               // Сохраните пост в базе данных
               postsService.save(newPost);

           }

       }
       return "redirect:/posts/index";
   }

    @GetMapping("posts/index")

    public String loadAllPosts(Model model){
        model.addAttribute("posts", postsService.getAllPosts());
        model.addAttribute("post", new Posts());

        return "/admin/posts/index";

    }
    @GetMapping("/post/create")

    public String createPost(Model model){
        System.out.println("create");
        model.addAttribute("post", new Posts());
        return "/admin/posts/create";

    }


    }


