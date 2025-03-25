package org.example;
//WAP that will retrieve data from Database and display on Console screen. (JDBC) for Students with attributes name, gender, div, sem, branch
import com.mysql.jdbc.Driver;

import java.sql.*;

public class Task {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_practical" , "root" , "");
            Statement statement = connection.createStatement();
            String Fetchquery = "SELECT * FROM student_p1";
            ResultSet resultSet = statement.executeQuery(Fetchquery);

            while(resultSet.next()) {
                System.out.println("Student Name :- " + resultSet.getString(2));
                System.out.println("Gender :- " + resultSet.getString(3));
                System.out.println("Division :- " + resultSet.getString(4));
                System.out.println("Semester :- " + resultSet.getString(5));
                System.out.println("Branch :- " + resultSet.getString(6));
                System.out.println("__________________________________________________________");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
