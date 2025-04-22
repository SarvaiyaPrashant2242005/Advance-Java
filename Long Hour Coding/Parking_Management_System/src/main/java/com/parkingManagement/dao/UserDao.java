package com.parkingManagement.dao;

import com.parkingManagement.model.Users;
import com.parkingManagement.util.DBConnection;
import java.sql.*;

public class UserDao {
    private static final String INSERT_USER_SQL = "INSERT INTO users (company_name, company_email, company_phone, company_address, parking_slots, password) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_SQL = "SELECT * FROM users WHERE company_email = ? AND password = ?";
    private static final String SELECT_USER_BY_ID_SQL = "SELECT * FROM users WHERE id = ?"; // New query to select user by id

    // Method to register a new user
    public boolean registerUser(Users user) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, user.getCompany_name());
            preparedStatement.setString(2, user.getCompany_email());
            preparedStatement.setString(3, user.getCompany_phone());
            preparedStatement.setString(4, user.getCompany_address());
            preparedStatement.setInt(5, user.getParking_slots());
            preparedStatement.setString(6, user.getPassword());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getInt(1));  // Setting the generated user id
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method for user login
    public Users loginUser(String email, String password) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));  // Set user id
                user.setCompany_name(rs.getString("company_name"));
                user.setCompany_email(rs.getString("company_email"));
                user.setCompany_phone(rs.getString("company_phone"));
                user.setCompany_address(rs.getString("company_address"));
                user.setParking_slots(rs.getInt("parking_slots"));
                user.setPassword(rs.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Optional: Method to get user by ID
    public Users getUserById(int userId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_SQL)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setCompany_name(rs.getString("company_name"));
                user.setCompany_email(rs.getString("company_email"));
                user.setCompany_phone(rs.getString("company_phone"));
                user.setCompany_address(rs.getString("company_address"));
                user.setParking_slots(rs.getInt("parking_slots"));
                user.setPassword(rs.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
