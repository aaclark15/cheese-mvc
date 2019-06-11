package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")

public class UserController {


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {

        model.addAttribute("title", "Add a New User");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUserForm(Model model, @ModelAttribute User user, String verify) {
        if(!user.getPassword().equals(verify)) {
            model.addAttribute("title", "Add a New User");
            String message = "Passwords do not match, please re-enter";
            model.addAttribute("message", message);
            return "user/add";
        }
        model.addAttribute("title", "My Cheeses");
        model.addAttribute("name", user.getUsername());
        return "user/index";
    }
}
