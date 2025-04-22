<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculation Results</title>
</head>
<body>
    <%
        // Fetch user inputs
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        // Validate inputs
        if (num1Str != null && num2Str != null) {
            try {
                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);

                // Perform calculations
                int sum = addNumbers(num1, num2);
                int difference = subtractNumbers(num1, num2);
                int product = multiplyNumbers(num1, num2);
                double quotient = divideNumbers(num1, num2);

    %>
    <h2>Results:</h2>
    <p>Sum: <%= sum %></p>
    <p>Difference: <%= difference %></p>
    <p>Product: <%= product %></p>
    <p>Quotient: <%= quotient %></p>
    <%
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Invalid input. Please enter numeric values.</p>");
            }
        }
    %>

    <!-- Declare Methods Correctly -->
    <%!
        public int addNumbers(int a, int b) {
            return a + b;
        }

        public int subtractNumbers(int a, int b) {
            return a - b;
        }

        public int multiplyNumbers(int a, int b) {
            return a * b;
        }

        public double divideNumbers(int a, int b) {
            if (b == 0) {
                return 0; // Handling division by zero
            }
            return (double) a / b;
        }
    %>
</body>
</html>
