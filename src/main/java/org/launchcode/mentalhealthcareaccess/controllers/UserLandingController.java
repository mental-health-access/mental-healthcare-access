package org.launchcode.mentalhealthcareaccess.controllers;

import org.launchcode.mentalhealthcareaccess.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLandingController {

    @GetMapping("/user")
    public String displayUserPage(Model model) {
        model.addAttribute("welcome", "Welcome");
        model.addAttribute("name","Name");
        return "user/user";
    }

}
