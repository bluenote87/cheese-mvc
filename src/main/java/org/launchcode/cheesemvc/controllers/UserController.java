package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Sign Into My Cheese Emporium");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User user, Errors errors, Model model, String verify) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign Into My Cheese Emporium");
            model.addAttribute(user);
            return "user/add";
        }
        String inputPassword = user.getPassword();
        if (inputPassword.equals(verify)) {
            model.addAttribute("title", "Hi there!");
            model.addAttribute("username", user.getUsername());
            return "user/index";
        } else {
            model.addAttribute("title", "Sign Into My Cheese Emporium");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            user.setPassword("");
            model.addAttribute("password", user.getPassword());
            model.addAttribute("userdanger", "Sorry, but passwords don't match. Try again.");
            return "user/add";
        }
    }
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "Sign Into My Cheese Emporium");
        model.addAttribute(new User());
        return "user/add";
    }


}
