package com.epsi.tp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void testLoginInvalidCredentials() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.login("admin", "admin"));
    }

    @Test
    void testLoginEmptyCredentials() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.login("", ""));
    }

    @Test
    void testGetUserDetailsNoDatabase() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.getUserDetails("john_doe"));
    }

    @Test
    void testComplexMethodAllPositive() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, 1, 1));
    }

    @Test
    void testComplexMethodANegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(-1, 1, 1));
    }

    @Test
    void testComplexMethodBNegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, -1, 1));
    }

    @Test
    void testComplexMethodCNegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, 1, -1));
    }

    @Test
    void testComplexMethodBAndCNegative() {
        UserService userService = new UserService();
        assertDoesNotThrow(() -> userService.complexMethod(1, -1, -1));
    }
}
