
package com.experiment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchUser")
public class searchUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String FN = request.getParameter("firstName");
        String LN = request.getParameter("lastName");
        String EMAIL = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj_practical", "root", "");

            String query = "SELECT * FROM task_2 WHERE firstName = ? AND lastName = ? AND email = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, FN);
            ps.setString(2, LN);
            ps.setString(3, EMAIL);

            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");
            if (rs.next()) {
                out.println("<h2>User Found:</h2>");
                out.println("<p>First Name: " + rs.getString("firstName") + "</p>");
                out.println("<p>Last Name: " + rs.getString("lastName") + "</p>");
                out.println("<p>Email: " + rs.getString("email") + "</p>");
            } else {
                out.println("<h2>No user found with the given details.</h2>");
            }
            out.println("</body></html>");

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
