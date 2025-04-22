package com.prashant.calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/Calc")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double num1 = Double.parseDouble(request.getParameter("first"));
            double num2 = Double.parseDouble(request.getParameter("second"));
            String operation = request.getParameter("operation");
            double result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        out.println("<h3>Error: Division by zero is not allowed.</h3>");
                        return;
                    }
                    break;
                default:
                    out.println("<h3>Error: Invalid Operation.</h3>");
                    return;
            }

            out.println("<html><body>");
            out.println("<h3>Answer is: " + result + "</h3>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<h3>Error: Please enter valid numbers.</h3>");
        }
    }
}
