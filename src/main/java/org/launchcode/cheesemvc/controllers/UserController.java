package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Sign Into My Cheese Emporium");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {
        String inputPassword = user.getPassword();
        if (inputPassword.equals(verify)) {
            model.addAttribute("title", "Hi there!");
            model.addAttribute("username", user.getUsername());
            return "user/index";
        } else {
            model.addAttribute("title", "Sign Into My Cheese Emporium");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("userdanger", "Sorry, but passwords don't match. Try again.");
            return "user/add";
        }
    }
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Sign Into My Cheese Emporium");
        return "user/add";
    }


}
