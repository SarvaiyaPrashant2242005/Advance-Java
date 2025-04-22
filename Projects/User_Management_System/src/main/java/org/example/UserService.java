package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    private int userIdCounter = 1; // Auto-increment user ID

    public UserService() {
        // Adding a default admin for login
        users.add(new User(userIdCounter++, "admin", "admin123", "admin"));
    }

    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Successful login
            }
        }
        return null; // Invalid credentials
    }

    public void addUser(String username, String password, String role) {
        users.add(new User(userIdCounter++, username, password, role));
    }

    public void updateUser(int userId, String newUsername, String newPassword, String newRole) {
        for (User user : users) {
            if (user.getId() == userId) {
                user.setUsername(newUsername);
                user.setPassword(newPassword);
                user.setRole(newRole);
                return;
            }
        }
        System.out.println("❌ User ID not found!");
    }

    public void deleteUser(int userId) {
        users.removeIf(user -> user.getId() == userId);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
