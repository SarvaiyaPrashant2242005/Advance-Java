package com.prashantsarvaiya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTransaction {
    private static final String URL = "jdbc:mysql://localhost:3306/aj_practical";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method to establish connection
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to insert data into the database
    public static boolean insertData(String name, String email, String phone) {
        String sql = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
