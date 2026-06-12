package com.epsi.tp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testLoginInvalidCredentials() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.login("admin", "admin"));
    }

    @Test
    public void testLoginEmptyCredentials() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.login("", ""));
    }

    @Test
    public void testGetUserDetailsNoDatabase() {
        UserService userService = new UserService();
        // La méthode doit attraper l'exception de connexion et ne pas propager
        assertDoesNotThrow(() -> userService.getUserDetails("john_doe"));
    }

    @Test
    public void testComplexMethodAllPositive() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, 1, 1));
    }

    @Test
    public void testComplexMethodANegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(-1, 1, 1));
    }

    @Test
    public void testComplexMethodBNegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, -1, 1));
    }

    @Test
    public void testComplexMethodCNegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, 1, -1));
    }

    @Test
    public void testComplexMethodBAndCNegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, -1, -1));
    }
}
