package org.launchcode.mentalhealthcareaccess.controllers;
import org.launchcode.mentalhealthcareaccess.models.data.ProviderRepository;
import org.launchcode.mentalhealthcareaccess.models.Provider;

import org.launchcode.mentalhealthcareaccess.models.data.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

public class ProviderController {

    @Autowired
    ProviderRepository providerRepository;
    //Static variable for the session key
    private static final String providerSessionKey = "provider";

    //Method to get the user info from the session
    public Provider getProviderFromSession(HttpSession session) {
        Integer providerId = (Integer) session.getAttribute(providerSessionKey);
        if (providerId == null) {
            return null;
        }

        Optional<Provider> provider = providerRepository.findById(providerId);

        if (provider.isEmpty()) {
            return null;
        }

        return provider.get();
    }

    //Method to set the user in the session
    private static void setProviderInSession(HttpSession session, Provider provider) {
        session.setAttribute(providerSessionKey, provider.getId());
    }

    @GetMapping("/provider/signup")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Sign-up");
        return "signup";
    }

    @PostMapping("/provider/signup")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign-up");
            return "signup";
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
        //1. Create new provider
        Provider newProvider = new Provider(registerFormDTO.getEmail(), registerFormDTO.getPassword());
        //2. Save new provider to the database
        providerRepository.save(newProvider);
        //3. Create new session for the user
        setProviderInSession(request.getSession(), newProvider);
        //4. Redirect to homepage
        return "redirect:";
    }
}
