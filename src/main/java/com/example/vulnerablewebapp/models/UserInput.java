package com.example.vulnerablewebapp.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDatabase {

    public String getUserById(String userId) {
        String result = "";
        Connection connection = null;
        Statement statement = null;

        try {
            // Connexion à la base de données (remplacez par vos informations)
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vulnerable_db", "root", "password"
            );

            statement = connection.createStatement();

            // Requête SQL construite directement avec les données utilisateur (vulnérabilité)
            String query = "SELECT * FROM users WHERE id = '" + userId + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                result = "User found: " + resultSet.getString("username");
            } else {
                result = "User not found";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
