package com.example.vulnerablewebapp.models;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserInputController {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @GetMapping("/displayUserInput")
    public String displayUserInput(@RequestParam("name") String name, Model model) {
        // Stockage direct de l'entrée utilisateur sans validation (vulnérabilité)
        setName(name);

        // Injection de l'entrée utilisateur dans le modèle, qui sera affiché dans une vue HTML
        model.addAttribute("userInput", getName());

        return "userInputView"; // Vue où la valeur sera affichée
    }
}
