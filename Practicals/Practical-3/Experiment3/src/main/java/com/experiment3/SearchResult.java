package com.experiment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchDOB")
public class SearchResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String dob = request.getParameter("dob");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_practical", "root", "");

            // Prepare SQL query
            String query = "SELECT Username, Email FROM people WHERE dob = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dob);

            ResultSet rs = ps.executeQuery();

            // Display results
            out.println("<h2>Users with Date of Birth: " + dob + "</h2>");
            out.println("<table border='1'><tr><th>Username</th><th>Email</th></tr>");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                out.println("<tr>");
                out.println("<td>" + rs.getString("Username") + "</td>");
                out.println("<td>" + rs.getString("Email") + "</td>");
                out.println("</tr>");
            }

            if (!hasData) {
                out.println("<tr><td colspan='2'>No users found with this DOB.</td></tr>");
            }

            out.println("</table>");

            // Close resources
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
