package org.launchcode.cheesemvc.controllers;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping("cheese") //makes base path /cheese
public class CheeseController {

    //putting list outside of method makes it global
    //using arraylist for data is temp - goes away when server stops
    //static ArrayList<String> cheeses = new ArrayList<>(); //creates a new list
    HashMap<String, String > cheeses = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses); //passes our list to our template
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    //new method to make Add form - the display
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    //create handler to process the form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //use @RequestParam as parameter to pull data from form - look for variable (needs to match form)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {
        cheeses.put(cheeseName, description);

        return "redirect:"; //redirect to /cheese (base path)
    }
}
