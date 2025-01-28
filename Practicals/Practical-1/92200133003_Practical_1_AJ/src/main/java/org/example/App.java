package org.example;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class App {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_practical" , "root" , "");
            Statement statement = connection.createStatement();
            String Fetchquery = "SELECT * FROM Student";
            ResultSet resultSet = statement.executeQuery(Fetchquery);

            while(resultSet.next()) {
                System.out.println("Student Name :- " + resultSet.getString(1));
                System.out.println("Enrollment Number :- " + resultSet.getString(2));
                System.out.println("Email :- " + resultSet.getString(3));
                System.out.println("Department :- " + resultSet.getString(4));
                System.out.println("Password :- " + resultSet.getString(5));
                System.out.println("__________________________________________________________");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
