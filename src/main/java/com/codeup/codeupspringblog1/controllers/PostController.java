package com.codeup.codeupspringblog1.controllers;

import com.codeup.codeupspringblog1.models.Post;
import com.codeup.codeupspringblog1.repositories.PostRepository;
import com.codeup.codeupspringblog1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {


    private PostRepository postDao;
    private UserRepository userDao;

    @Autowired
    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
