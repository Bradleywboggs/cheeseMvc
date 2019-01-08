package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model) {
        model.addAttribute("title", "Sign Up");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddForm(Model model, @ModelAttribute @Valid User user, Errors errors, @RequestParam String verify) {
        boolean formErrorCheck = false;
        String pwErrorMessage= "";

        if (errors.hasErrors()) {
            formErrorCheck = true;
        }
        if (!verify.equals(user.getPassword())) {
            pwErrorMessage = "Passwords did not match";
            model.addAttribute("pwErrorMessage", pwErrorMessage);
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("username", user.getUsername());
        }
        if (formErrorCheck == true || !pwErrorMessage.isEmpty()) {
            model.addAttribute("title", "Sign Up");
            return "user/add";
        } else {
            UserData.add(user);
            model.addAttribute("user", user);
            model.addAttribute("title", "Welcome");
            return "user/index";

        }
    }
}
