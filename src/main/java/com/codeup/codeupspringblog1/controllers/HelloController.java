package com.codeup.codeupspringblog1.controllers;

import com.codeup.codeupspringblog1.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    @ResponseBody
    public String helloWorld() {
        return "Hello, World!";
    }

//    @GetMapping("/{name}")
//    @ResponseBody
//    public String helloName(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        List<Item> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Item("screwdriver"));
        shoppingCart.add(new Item("hammer"));
        shoppingCart.add(new Item("drill"));
        model.addAttribute("shoppingCart", shoppingCart);
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }


}
