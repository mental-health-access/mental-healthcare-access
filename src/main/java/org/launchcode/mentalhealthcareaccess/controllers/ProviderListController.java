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
@RequestMapping(value = "providers")




public class ProviderListController {
    @Autowired
    private ProviderRepository providerRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ProviderListController() {

        columnChoices.put("all", "All");
        columnChoices.put("providers", "Providers");


    }

    @RequestMapping("")
    public String displayAllProviders(Model model) {
        model.addAttribute("title", "All Providers");
        model.addAttribute("providers", providerRepository.findAll());
        return "list";
    }


    @RequestMapping("/{id}")
    public String displayViewProvider(Model model, @PathVariable int id) {

        Optional<Provider> provider = providerRepository.findById(id);
        if(provider.isPresent()){
            model.addAttribute("provider", provider.get());
            return "provider/view";
        }


        return "provider/not-found" ;

    }
}
