package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== User Management System =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (option == 2) {
                System.out.println("Exiting... 👋");
                break;
            }

            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Authenticate User
            User user = userService.loginUser(username, password);
            if (user == null) {
                System.out.println("❌ Invalid Credentials! Please try again.");
                continue;
            }

            if (user.getRole().equalsIgnoreCase("admin")) {
                adminPanel(userService, scanner);
            } else {
                System.out.println("\n✅ Welcome, " + user.getUsername() + "!");
                System.out.println("Your details: " + user);
            }
        }

        scanner.close();
    }

    private static void adminPanel(UserService userService, Scanner scanner) {
        while (true) {
            System.out.println("\n===== Admin Panel =====");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. View Users");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int adminOption = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (adminOption == 5) {
                System.out.println("Logging out... ⏳");
                break;
            }

            switch (adminOption) {
                case 1:
                    System.out.print("Enter New Username: ");
                    String newUser = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter Role (admin/user): ");
                    String role = scanner.nextLine();
                    userService.addUser(newUser, newPassword, role);
                    System.out.println("✅ User added successfully!");
                    break;

                case 2:
                    System.out.print("Enter User ID to Update: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Username: ");
                    String updatedUser = scanner.nextLine();
                    System.out.print("Enter New Password: ");
                    String updatedPass = scanner.nextLine();
                    System.out.print("Enter New Role (admin/user): ");
                    String updatedRole = scanner.nextLine();
                    userService.updateUser(userId, updatedUser, updatedPass, updatedRole);
                    System.out.println("✅ User updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter User ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    userService.deleteUser(deleteId);
                    System.out.println("✅ User deleted successfully!");
                    break;

                case 4:
                    List<User> users = userService.getAllUsers();
                    System.out.println("\n===== User List =====");
                    for (User u : users) {
                        System.out.println(u);
                    }
                    break;

                default:
                    System.out.println("❌ Invalid Option! Please choose again.");
            }
        }
    }
}
