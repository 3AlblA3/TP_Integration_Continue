package com.epsi.tp;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Démarrage de l'application...");

        String user = System.getenv("APP_USER");
        String password = System.getenv("APP_PASSWORD");

        UserService userService = new UserService();
        userService.login(user, password);
        userService.getUserDetails(user);
    }
}
