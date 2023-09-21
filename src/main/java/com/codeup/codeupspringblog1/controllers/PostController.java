package com.codeup.codeupspringblog1.controllers;

import com.codeup.codeupspringblog1.models.Post;
import com.codeup.codeupspringblog1.models.User;
import com.codeup.codeupspringblog1.repositories.PostRepository;
import com.codeup.codeupspringblog1.repositories.UserRepository;
import com.codeup.codeupspringblog1.services.EmailSvc;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {


    private PostRepository postDao;
    private UserRepository userDao;
    private EmailSvc emailSvc;


    public PostController(PostRepository postDao, UserRepository userDao, EmailSvc emailSvc) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
    }


    @GetMapping("")
    public String index(Model model) {
        List<Post> postArr = postDao.findAll();
        model.addAttribute("posts", postArr);
        return "post/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        if (postDao.existsById(id)) {
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);
            return "post/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String showCreatePostView(Model model) {
        Post postToEdit = postDao.findById(1L).get();
        model.addAttribute("post", postToEdit);
//        model.addAttribute("post", new Post());
        return "post/create";
    }


    @PostMapping("/create")
    public String createNewPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postToSave = new Post(
                post.getTitle(),
                post.getBody(),
                user
        );
        postDao.save(postToSave);
        emailSvc.prepareAndSend(postToSave, "You created a post!!", "Here is some more information about the post you created... yay.");
        return "redirect:/posts";
    }


    @GetMapping("/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        Post postToEdit = postDao.findById(id).get();
        model.addAttribute("post", postToEdit);
        return "post/edit";
    }


    @PostMapping("/{id}/edit")
    public String insertEdit(@ModelAttribute Post post, @PathVariable long id){
        Post postToEdit = postDao.findById(id).get();
        postToEdit.setTitle(post.getTitle());
        postToEdit.setBody(post.getBody());
        postDao.save(postToEdit);
        return "redirect:/posts/" + id;
    }






}
