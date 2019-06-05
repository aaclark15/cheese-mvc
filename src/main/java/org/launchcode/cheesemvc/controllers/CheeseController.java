package org.launchcode.cheesemvc.controllers;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


@Controller
@RequestMapping("cheese") //makes base path /cheese
public class CheeseController {

    //putting list outside of method makes it global
    //using arraylist for data is temp - goes away when server stops
    static ArrayList<Cheese> cheeses = new ArrayList<Cheese>(); //creates a new list
    //static HashMap<String, String > cheeses = new HashMap<>();
    public Integer checkedID = 0;

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

        Cheese newCheese = new Cheese(cheeseName, description);
        cheeses.add(newCheese);

        return "redirect:"; //redirect to /cheese (base path)
    }

    //new method to make Remove form - the display
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {

        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses); //passes our list to our template
        model.addAttribute("checkedID", checkedID);

        return "cheese/remove";
    }

    //create handler to remove a cheese
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheese(@RequestParam ArrayList<String> cheeseList) {

        //for (int i = 0; i < cheeseList.size(); i++) {cheeses.remove(cheeseList.get(i));}
        if (cheeseList != null) {
            for (String cheese : cheeseList) {
                for (Cheese cheeseObj : cheeses) {

                    if (cheeseObj.getName().equals(cheese)) {
                        cheeses.remove(cheeseObj);
                        break;
                    }
                }
            }
        }
        return "redirect:" ;
    }
}
