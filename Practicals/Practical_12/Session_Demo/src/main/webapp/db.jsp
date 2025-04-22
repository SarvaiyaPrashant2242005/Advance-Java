<%@ page import="java.sql.*" %>
<%
    String url = "jdbc:mysql://localhost:3306/aj_practical";
    String user = "root";
    String pass = "";
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
        application.setAttribute("dbConnection", con);
    } catch (Exception e) {
        out.println("Database connection error: " + e);
    }
%>
