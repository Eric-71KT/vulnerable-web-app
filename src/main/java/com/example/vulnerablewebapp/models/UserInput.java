package com.example.vulnerablewebapp.controllers;

import com.example.vulnerablewebapp.models.UserInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class VulnerableController {

    @GetMapping("/vulnerable")
    public String vulnerableEndpoint(HttpServletRequest request, Model model) {
        UserInput userInput = new UserInput();
        // Données utilisateur non échappées injectées dans la vue
        model.addAttribute("userName", userInput.getUnsafeUserInput(request));
        return "vulnerableView"; // Vue affichant potentiellement un XSS
    }
}
