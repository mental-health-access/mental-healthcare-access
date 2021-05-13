package org.launchcode.mentalhealthcareaccess.controllers;

import org.launchcode.mentalhealthcareaccess.models.data.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

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

    @RequestMapping("")
    public String list(Model model){

        model.addAttribute("providers", providerRepository.findAll());
        return "provider/list";

    }
}
