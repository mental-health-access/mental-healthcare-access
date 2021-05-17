package org.launchcode.mentalhealthcareaccess.controllers;

import org.launchcode.mentalhealthcareaccess.models.Provider;
import org.launchcode.mentalhealthcareaccess.models.data.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping(value = "list")



public class ProviderListController {
    @Autowired
    private ProviderRepository providerRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ProviderListController() {

        columnChoices.put("all", "All");
        columnChoices.put("providers", "Providers");


    }

    @GetMapping("")
    public String displayAllProviders(Model model) {
        model.addAttribute("title", "All Providers");
        model.addAttribute("providers", providerRepository.findAll());
        return "list";
    }


    @PostMapping("provider/view/{providerId}")
    public String displayViewProvider(Model model, @PathVariable int providerId) {

        Provider provider = providerRepository.findById(providerId).get();
        model.addAttribute("provider", provider);
        return "provider/view";

    }
}