package org.launchcode.mentalhealthcareaccess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//This controller was created strictly to test for bootstrap implementation
@Controller
public class BootstrapTestController {

    //handles request at path localhost:8080/bootstrap
    @GetMapping("bootstrap")
    public String helloBootstrap(Model model) {

        model.addAttribute("title", "Bootstrap Dependency Test Page");
        return "bootstrap-test";
    }
}
