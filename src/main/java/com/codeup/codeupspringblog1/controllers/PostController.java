package com.codeup.codeupspringblog1.controllers;



import com.codeup.codeupspringblog1.models.Post;
import com.codeup.codeupspringblog1.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLDocument;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Post> postArr = postDao.findAll();
        model.addAttribute("posts", postArr);
        return "post/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        if (postDao.existsById(id)) {
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);
            return "post/show";
        }
            return "redirect:/posts";
    }

    @GetMapping("/create")
    public String showCreatePostView () {
        return "post/create";
    }


    @PostMapping("/create")
//    @ResponseBody
    public String createNewPost(@RequestParam(name = "title") String title, @RequestParam(name="body") String body) {
        postDao.save(new Post(title, body));
        return "redirect:/posts";
    }

}
