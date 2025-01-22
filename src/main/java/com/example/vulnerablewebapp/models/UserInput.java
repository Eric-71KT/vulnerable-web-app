package com.example.vulnerablewebapp.models;

import jakarta.servlet.http.HttpServletRequest;

public class UserInput {

    public String getUnsafeUserInput(HttpServletRequest request) {
        // Récupération directe des paramètres utilisateur sans validation
        String userInput = request.getParameter("name");
        return userInput; // Données non échappées renvoyées telles quelles
    }

    public String getSafeUserInput(HttpServletRequest request) {
        // Exemple d'utilisation correcte (échappement HTML ou nettoyage des données)
        String userInput = request.getParameter("name");
        return org.apache.commons.text.StringEscapeUtils.escapeHtml4(userInput);
    }
}
