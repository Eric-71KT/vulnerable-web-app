package com.example.vulnerablewebapp.controllers;

import com.example.vulnerablewebapp.models.UserInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/submit")
    public String submit(UserInput userInput, Model model) {
        model.addAttribute("message", "Ton nom est " + userInput.getName());
        return "result";
    }
}