package com.emicalculation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Calculation")
public class Calculate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            // Parse input values from the form
            double principal = Double.parseDouble(req.getParameter("principal"));
            double rate = Double.parseDouble(req.getParameter("rate")); // Changed from int to double
            int duration = Integer.parseInt(req.getParameter("duration"));

            // Convert annual interest rate to monthly rate
            double monthlyRate = rate / 12 / 100; // Ensure correct division

            // EMI formula: EMI = [P * r * (1+r)^n] / [(1+r)^n - 1]
            double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, duration)) /
                    (Math.pow(1 + monthlyRate, duration) - 1);

            // Display result
            out.println("<html><body>");
            out.println("<h2>EMI Calculation Result</h2>");
            out.println("<p>Principal Amount: ₹" + principal + "</p>");
            out.println("<p>Annual Interest Rate: " + rate + "%</p>");
            out.println("<p>Duration: " + duration + " months</p>");
            out.println("<h3>Your Monthly EMI: ₹" + String.format("%.2f", emi) + "</h3>");
            out.println("<br><a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<p style='color:red;'>Invalid input! Please enter valid numbers.</p>");
            out.println("<br><a href='index.html'>Go Back</a>");
        }
    }
}
