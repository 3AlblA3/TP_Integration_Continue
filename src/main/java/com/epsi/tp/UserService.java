package com.epsi.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private String dbPassword = System.getenv("DB_PASSWORD");

    public void login(String username, String password) {
        LOGGER.log(Level.INFO, "Tentative de connexion de l'utilisateur : {0}", username);

        String adminUser = System.getenv("ADMIN_USER");
        String adminPass = System.getenv("ADMIN_PASS");

        if (adminUser != null && adminUser.equals(username) && adminPass != null && adminPass.equals(password)) {
            LOGGER.info("Administrateur connecté avec succès.");
        } else {
            LOGGER.warning("Identifiants invalides.");
        }
    }

    public void getUserDetails(String username) {
        String query = "SELECT username FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LOGGER.log(Level.INFO, "Utilisateur trouvé : {0}", rs.getString("username"));
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur lors de la récupération de l'utilisateur : {0}", e.getMessage());
        }
    }

    public void complexMethod(int a, int b, int c) {
        if (a <= 0) {
            LOGGER.info("A est négatif");
        } else if (b <= 0 && c <= 0) {
            LOGGER.info("B et C sont négatifs");
        } else if (b <= 0) {
            LOGGER.info("B est négatif");
        } else if (c <= 0) {
            LOGGER.info("C est négatif");
        } else {
            LOGGER.info("Tous positifs");
        }
    }
}
