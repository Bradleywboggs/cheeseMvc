package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String> cheeses = new HashMap<>();
    static String nameErrorMessage;

    private static boolean isLettersSpaces(String someString) {
        Pattern p = Pattern.compile("^[ A-Za-z]+$");
        Matcher m = p.matcher(someString);
        boolean b = m.matches();
        return b;
    }

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription, Model model) {

        if (cheeseName.isEmpty() || isLettersSpaces(cheeseName) == false) {
            nameErrorMessage = "This input is not valid";
            model.addAttribute("nameError", nameErrorMessage);
            model.addAttribute("cheeses", cheeses);
            model.addAttribute("title", "My Cheeses");
            return "cheese/add";

        } else {
            cheeses.put(cheeseName, cheeseDescription);

            // Redirect to /cheese
            return "redirect:";

        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Remove Cheese");
        return "/cheese/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheeseList) {
        if (cheeseList == null) {
            return "/cheese/remove";
        } else {
            for (String cheese : cheeseList) {
                cheeses.remove(cheese);

            }return "redirect:";
        }


    }
}

