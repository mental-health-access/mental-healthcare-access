package org.launchcode.mentalhealthcareaccess.controllers;
import org.launchcode.mentalhealthcareaccess.models.data.ProviderRepository;
import org.launchcode.mentalhealthcareaccess.models.Provider;

import org.launchcode.mentalhealthcareaccess.models.data.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;
@Controller
public class ProviderController {

    @Autowired
    ProviderRepository providerRepository;



     @GetMapping("provider/signup")
     public String displaySignUpForm(Model model) {
         model.addAttribute(new RegisterFormDTO());
         model.addAttribute("title", "Register");
         return "/provider/signup";
    }

    @PostMapping("/provider/signup")
    public String processSignUpForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign-up");
            return "/provider/signup";
        }

        Provider existingProvider = providerRepository.findByEmail(registerFormDTO.getEmail());

        if (existingProvider != null) {
            //This is a custom error
            errors.rejectValue("email", "email.alreadyexists", "This email is already registered, please choose anew one");
            model.addAttribute("title", "Register");
            return "register";
        }
        //This password was set in LoginFormDTO
        String password = registerFormDTO.getPassword();
        //This password was set in RegisterFormDTO that EXTENDS LoginFormDTO
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Sign-up");
            return "register";
        }

        Provider newProvider = new Provider(registerFormDTO.getName(),
                registerFormDTO.getLastName(),
                registerFormDTO.getEmail(),
                registerFormDTO.getPhoneNumber(),
                registerFormDTO.getPassword());

        providerRepository.save(newProvider);

        return "redirect:";
    }
}
