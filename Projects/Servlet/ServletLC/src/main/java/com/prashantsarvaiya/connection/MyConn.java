package com.prashantsarvaiya.connection;

import java.sql.*;

public class MyConn {
    public static MyConn connObj;
    Connection connection;
    private MyConn(){
        createConnction();
    }
    public static MyConn getInstance(){
        if(connObj==null)
            connObj = new MyConn();
        return connObj;
    }
    public void createConnction(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_tbl","root","");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public String validateUser(String unm, String pwd){
        String result = "No user found";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user_tbl where username = '"+unm+"' and pwd='"+pwd+"'");
            if(rs.next()){
                result = rs.getString("username");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
