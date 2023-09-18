package com.codeup.codeupspringblog1.controllers;


import com.codeup.codeupspringblog1.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
//    @ResponseBody
    public String index(Model model){
        List<Post> postArr = new ArrayList<>();
        Post newpost = new Post("Hello", "Hello World");
        Post newpost2 = new Post("Codeup", "Hello Codeup");

        postArr.add(newpost);
        postArr.add(newpost2);

        model.addAttribute("posts", postArr);

        return "post/index";
    }

    @GetMapping("/{id}")
//    @ResponseBody
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post newpost = new Post("Hello", "Hello World");
        model.addAttribute("post", newpost);
        return "posts/show";
    }

    @GetMapping("/create")
//    @ResponseBody
    public String showCreatePostView() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
//    @ResponseBody
    public String createNewPost() {
        return "create a new post";
    }

}
