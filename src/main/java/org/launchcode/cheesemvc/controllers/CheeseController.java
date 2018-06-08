package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheese Emporium");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }

        CheeseData.add(newCheese);
        // Redirect to /cheese
        return "redirect:";
    }

    //Request path: cheese/remove
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String showRemoveForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", CheeseData.getAll());

        return "cheese/remove";

    }

    //Request path: cheese/remove
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveForm(@RequestParam int[] cheeseIds) {

        for(int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        Cheese editCheese = CheeseData.getById(cheeseId);
        String cheeseName = editCheese.getName();
        Integer cheeseIdentification = editCheese.getCheeseId();
        String aCheese = cheeseIdentification.toString();
        model.addAttribute("title", "Edit Cheese " + cheeseName + " (id=" + aCheese + ")");
        model.addAttribute("cheese", editCheese);
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese thisCheese,
                                  Errors errors, String name,
                                  String description, CheeseType type, int rating, Model model) {
        if (errors.hasErrors()) {
            Integer cheeseIdentification = thisCheese.getCheeseId();
            String aCheese = cheeseIdentification.toString();
            model.addAttribute("title", "Edit Cheese " + thisCheese.getName() + " (id=" + aCheese + ")");
            model.addAttribute("cheese", thisCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        Cheese oldCheese = CheeseData.getById(thisCheese.getCheeseId());
        oldCheese.setName(name);
        oldCheese.setDescription(description);
        oldCheese.setType(type);
        oldCheese.setRating(rating);
        return "redirect:";
    }

}