package com.example.UserLoginGradle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author neilbararugurika
 */
import javax.swing.JOptionPane;  // Importing Swing library for GUI dialog boxes

public class UserLogin{

    // These variables store user registration information
        public static String firstName;
        public static String lastName;
        public static String savedUsername;
        public static String savedPassword;
        static boolean isLoggedIn = false; // Tracks login state of the user

    // Method to check if the username is valid
    public static boolean checkUserName(String username) {
        // Username must contain "_" and be no more than 5 characters
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity requirements
    public static boolean checkPasswordComplexity(String password) {
        // Password must be at least 8 characters and contain:
        // at least one uppercase letter, one digit, and one special character
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()_+=<>?/].*");
    }

    // Method to register the user, storing username and password if valid
    public static String registerUser(String username, String password) {
        // Validate the username format
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        // Validate the password format
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }

        // Store valid credentials
        savedUsername = username;
        savedPassword = password;

        // Return success message
        return "Username and password successfully captured.";
    }

    // Method to log in the user
    public static boolean loginUser(String enteredUsername, String enteredPassword) {
        // Compare entered credentials with saved ones
        return savedUsername.equals(enteredUsername) && savedPassword.equals(enteredPassword);
    }

    // Method to return login feedback message
    public static String returnLoginStatus(boolean success) {
        // If login was successful, greet the user
        if (success) {
            return "Welcome " + firstName + ", " + lastName + "! It is great to see you again.";
        } 
        // If login failed, prompt the user to retry
        else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main method - entry point of the program
    public static void main(String[] args) {
        // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to the Registration System!");

        // Ask for first and last name
        firstName = JOptionPane.showInputDialog("Enter your first name:");
        lastName = JOptionPane.showInputDialog("Enter your last name:");

        // Ask the user to create a username with specific format
        String username = JOptionPane.showInputDialog("Create a username:\n(Format: include _ and max 5 characters)");

        // Ask the user to create a password that meets complexity rules
        String password = JOptionPane.showInputDialog("Create a strong password:\n(At least 8 characters, capital letter, number, and special character)");

        // Register the user and get a message indicating success or failure
        String registrationMessage = registerUser(username, password);

        // Show the registration result to the user
        JOptionPane.showMessageDialog(null, registrationMessage);

        // If registration was successful, move to login
        if (registrationMessage.contains("successfully")) {
            JOptionPane.showMessageDialog(null, "Proceeding to login...");

            // Ask for login credentials
            String loginUsername = JOptionPane.showInputDialog("Login - Enter your username:");
            String loginPassword = JOptionPane.showInputDialog("Login - Enter your password:");

            // Attempt login
            boolean loginSuccess = loginUser(loginUsername, loginPassword);
            isLoggedIn = loginSuccess;

            // Show login feedback message
            String loginMessage = returnLoginStatus(loginSuccess);
            JOptionPane.showMessageDialog(null, loginMessage);
        } 
        // If registration failed, ask user to restart
        else {
            JOptionPane.showMessageDialog(null, "Registration failed. Please restart the application and try again.");
        }
    }

    static String registerUser(String neil, String bararugurika, String neilb, String pass123) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


