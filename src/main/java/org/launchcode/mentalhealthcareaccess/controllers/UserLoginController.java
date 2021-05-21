package org.launchcode.mentalhealthcareaccess.controllers;

import org.launchcode.mentalhealthcareaccess.models.dto.UserLoginFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserLoginController {

    @GetMapping("user/login")
    public String displayLogInForm(Model model) {
        model.addAttribute(new UserLoginFormDTO());
        return "user-login";
    }

//    @PostMapping("/user/login")
//    public String processLoginForm(@ModelAttribute @Valid UserLoginFormDTO userLoginFormDTO, Errors errors, HttpServletRequest request, Model model) {
//        if (errors.hasErrors()) {
//            return "user-login";
//        }
//
//
//    }

}