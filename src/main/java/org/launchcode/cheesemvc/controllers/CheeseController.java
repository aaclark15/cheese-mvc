package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("cheese") //makes base path /cheese
public class CheeseController {

    //putting list outside of method makes it global
    //using arraylist for data is temp - goes away when server stops
    //public int checkedID = 0;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll()); //passes our list to our template
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
    //changing for model binding - delete @RequestParam var and auto create cheese obj
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {

        //Cheese newCheese = new Cheese(cheeseName, description); - now creating this with ModelAttribute
        CheeseData.add(newCheese);

        return "redirect:"; //redirect to /cheese (base path)
    }

    //new method to make Remove form - the display
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {

        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", CheeseData.getAll()); //passes our list to our template
        //model.addAttribute("checkedID", checkedID);

        return "cheese/remove";
    }

    //create handler to remove a cheese
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheese(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }
//        if (cheeseList != null) {
//            for (String cheese : cheeseList) {
//                for (Cheese cheeseObj : cheeses) {
//
//                    if (cheeseObj.getName().equals(cheese)) {
//                        cheeses.remove(cheeseObj);
//                        break;
//                    }
//                }
//            }
//        }
        return "redirect:" ;
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        model.addAttribute("title", "Edit Cheese");
        model.addAttribute("cheese", CheeseData.getById(cheeseId));
        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(@PathVariable int cheeseId,
                                  @RequestParam String name, @RequestParam String description) {

        Cheese editCheese = CheeseData.getById(cheeseId);
        editCheese.setName(name);
        editCheese.setDescription(description);

        return "redirect:/cheese" ;

    }
}
