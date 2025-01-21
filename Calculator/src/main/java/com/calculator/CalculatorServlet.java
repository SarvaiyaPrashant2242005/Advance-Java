package com.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Ensure doPost does not redundantly execute doGet logic
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            int num1 = Integer.parseInt(req.getParameter("num1"));
            int num2 = Integer.parseInt(req.getParameter("num2"));
            String operation = req.getParameter("Operation");
            int resu = 0;

            switch (operation) {
                case "+":
                    resu = num1 + num2;
                    break;
                case "-":
                    resu = num1 - num2;
                    break;
                case "*":
                    resu = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        out.println("Error: Division by zero is not allowed.");
                        return;
                    }
                    resu = num1 / num2;
                    break;
                default:
                    out.println("Error: Invalid operation.");
                    return;
            }

            out.println("Result: " + resu);
        } catch (NumberFormatException e) {
            out.println("Error: Invalid number format.");
        }
    }
}
