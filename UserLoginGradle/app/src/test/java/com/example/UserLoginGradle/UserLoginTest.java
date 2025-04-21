/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.UserLoginGradle;

/**
 *
 * @author neilbararugurika
 */



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserLoginTest {


    @Test
    void testValidUsername() {
        assertTrue(UserLogin.checkUserName("ne_il"));
    }

    @Test
    void testInvalidUsernameTooLong() {
        assertFalse(UserLogin.checkUserName("neil_barar")); // longer than 5 chars
    }

    @Test
    void testInvalidUsernameNoUnderscore() {
        assertFalse(UserLogin.checkUserName("neil"));
    }

    @Test
    void testValidPassword() {
        assertTrue(UserLogin.checkPasswordComplexity("Pass123!"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(UserLogin.checkPasswordComplexity("pass123!"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(UserLogin.checkPasswordComplexity("Password!"));
    }

    @Test
    void testInvalidPasswordNoSpecialChar() {
        assertFalse(UserLogin.checkPasswordComplexity("Password1"));
    }

    @Test
    void testRegisterUserValidCredentials() {
        String result = UserLogin.registerUser("ne_il", "Pass123!");
        assertEquals("Username and password successfully captured.", result);
    }

    @Test
    void testRegisterUserInvalidUsername() {
        String result = UserLogin.registerUser("neilbarar", "Pass123!");
        assertTrue(result.contains("Username is not correctly formatted"));
    }

    @Test
    void testRegisterUserInvalidPassword() {
        String result = UserLogin.registerUser("ne_il", "pass");
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    @Test
    void testLoginSuccess() {
        UserLogin.registerUser("ne_il", "Pass123!");
        assertTrue(UserLogin.loginUser("ne_il", "Pass123!"));
    }

    @Test
    void testLoginFailure() {
        UserLogin.registerUser("ne_il", "Pass123!");
        assertFalse(UserLogin.loginUser("ne_il", "wrongpass"));
    }

    @Test
    void testReturnLoginStatusSuccess() {
        UserLogin.firstName = "Neil";
        UserLogin.lastName = "Bararugurika";
        String message = UserLogin.returnLoginStatus(true);
        assertEquals("Welcome Neil, Bararugurika! It is great to see you again.", message);
    }

    @Test
    void testReturnLoginStatusFailure() {
        String message = UserLogin.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", message);
    }
}
