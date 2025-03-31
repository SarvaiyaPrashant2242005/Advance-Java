package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user inputs
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        // Save username and email to XML file
        saveUserToXML(username, email);

        // Display output on webpage
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>User Details</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Email-ID: " + email + "</p>");
        out.println("</body></html>");
    }

    private void saveUserToXML(String username, String email) {
        try {
            File xmlFile = new File("D:\\SEMESTER 6\\Advance-Java\\Practicals\\Practical_5\\Login\\src\\main\\webapp\\data.xml"); // Change path if needed
            if (!xmlFile.exists()) {
                FileWriter writer = new FileWriter(xmlFile);
                writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<users>\n</users>");
                writer.close();
            }

            // Append new username and email entry
            FileWriter writer = new FileWriter(xmlFile, true);
            writer.write("\n<user>\n");
            writer.write("\t<username>" + username + "</username>\n");
            writer.write("\t<email>" + email + "</email>\n");
            writer.write("</user>\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
