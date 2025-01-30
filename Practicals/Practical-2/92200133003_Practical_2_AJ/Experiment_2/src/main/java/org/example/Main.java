package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void Insert(Statement statement) {
        Scanner scanner = new Scanner(System.in);
        int no_of_rows;

        System.out.print("Enter The Number of Rows You Have to Insert :- ");
        no_of_rows = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Define the attributes (column names)
        String[] attribute = {"Username", "Email", "Enrollment", "Department", "Password"};
        String[][] data = new String[no_of_rows][5]; // Array to store user input

        // Taking user input
        for (int i = 0; i < no_of_rows; i++) {
            System.out.println("Enter the Details for User - " + (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.print("Enter the " + attribute[j] + " :- ");
                data[i][j] = scanner.nextLine();
            }
            System.out.println("_______________________________________________________________________________");
        }

        // Construct SQL INSERT query
        StringBuilder insertQuery = new StringBuilder("INSERT INTO `student`(`username`, `email`, `enrollment`, `department`, `password`) VALUES ");

        for (int i = 0; i < no_of_rows; i++) {
            insertQuery.append("('")
                    .append(data[i][0]).append("', '")  // Username
                    .append(data[i][1]).append("', '")  // Email
                    .append(data[i][2]).append("', '")  // Enrollment
                    .append(data[i][3]).append("', '")  // Department
                    .append(data[i][4]).append("')");   // Password

            if (i < no_of_rows - 1) {
                insertQuery.append(", "); // Append a comma for multiple inserts
            }
        }

        insertQuery.append(";");

        // Execute the query
        try {
            statement.executeUpdate(insertQuery.toString());
            System.out.println("Data Inserted Successfully!\n");
            Display(statement); // Display the table contents after insertion
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void Display(Statement statement) throws SQLException {
        String fetch_query = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(fetch_query);

        System.out.println("\n----- Student Table Data -----");
        while (resultSet.next()) {
            System.out.println("Username: " + resultSet.getString("username"));
            System.out.println("Email: " + resultSet.getString("email"));
            System.out.println("Enrollment: " + resultSet.getString("enrollment"));
            System.out.println("Department: " + resultSet.getString("department"));
            System.out.println("Password: " + resultSet.getString("password"));
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish Connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_practical", "root", "");
            Statement statement = connection.createStatement();

            // Call Insert function
            Insert(statement);

            // Close resources
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
