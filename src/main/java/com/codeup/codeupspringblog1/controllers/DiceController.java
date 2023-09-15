package com.codeup.codeupspringblog1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

    @GetMapping("roll-dice")
    public String rollDice() {
        return "rolldice";
    }

    @GetMapping("/roll-dice/{num}")
    public String diceRoll(@PathVariable int num, Model model) {
        int rand_int = ThreadLocalRandom.current().nextInt(1, 7);
        int rand_int2 = ThreadLocalRandom.current().nextInt(1, 7);
        int rand_int3 = ThreadLocalRandom.current().nextInt(1, 7);
        int rand_int4 = ThreadLocalRandom.current().nextInt(1, 7);
        int rand_int5 = ThreadLocalRandom.current().nextInt(1, 7);

        List<Integer>diceRolls = new ArrayList<>();

        diceRolls.add(rand_int);
        diceRolls.add(rand_int2);
        diceRolls.add(rand_int3);
        diceRolls.add(rand_int4);
        diceRolls.add(rand_int5);

//        if(rand_int == num) {
//            model.addAttribute("match", "It's a match!");
//        } else {
//            model.addAttribute("match", "This is not a match.");
//        }
        int bucket = 0;
        for(var i = 0; i < diceRolls.size(); i++) {
            if(diceRolls.get(i) == num) {
                bucket++;
            }
        }

        model.addAttribute("choice", num);
        model.addAttribute("result", diceRolls);
        model.addAttribute("match", "Your dice matched: " + bucket + " times.");
        return "rolldice";
    }


}
