package org.launchcode.controllers;

import org.springframework.ui.Model;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("user")
public class UserController {

@RequestMapping("add")
public String displayAddUserForm() {
    return "user/add";
}

    @RequestMapping(method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (user.getPassword().equals(verify)) {
            model.addAttribute("username", user.getUsername());
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords do not match");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }




}


