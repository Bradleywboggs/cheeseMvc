package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class CheeseController {

    @RequestMapping(value = "/cheese")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "/cheese/add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "/cheese/add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "cheese/add";
        }
        CheeseData.add(newCheese);
        // Redirect to /cheese
        return "redirect:/cheese";

    }

    @RequestMapping(value = "/cheese/remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "/cheese/remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
        if (cheeseIds == null) {
            return "cheese/remove";

        }
        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:/cheese";

    }

    @RequestMapping(value = "/cheese/edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditCheeseForm(Model model, @PathVariable int cheeseId) {
        model.addAttribute("cheese", CheeseData.getById(cheeseId));
        model.addAttribute("title", "Edit Cheese");
        return "cheese/edit";
    }

    @RequestMapping(value = "/cheese/edit", method = RequestMethod.POST)
    public String processEditCheeseForm(@RequestParam int cheeseId, @RequestParam String name, @RequestParam String description) {
        CheeseData.getById(cheeseId).setName(name);
        CheeseData.getById(cheeseId).setDescription(description);
        return "redirect:/cheese";

    }
}
