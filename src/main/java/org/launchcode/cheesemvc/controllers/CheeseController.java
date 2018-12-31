package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import static org.launchcode.cheesemvc.Validations.isLettersSpaces;
import static org.launchcode.cheesemvc.models.CheeseData.*;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static String nameErrorMessage;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
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

            Cheese newCheese = new Cheese(cheeseName, cheeseDescription);
            CheeseData.add(newCheese);
            // Redirect to /cheese
            return "redirect:";

        }
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "/cheese/remove";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int [] cheeseIds) {
        if (cheeseIds == null) {
            return "/cheese/remove";

        } for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";

    }
}
