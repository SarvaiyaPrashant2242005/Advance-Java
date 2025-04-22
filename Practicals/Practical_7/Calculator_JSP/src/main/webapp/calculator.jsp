<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Calculator</title>
</head>
<body>
    <form method="post">
        First Number: <input type="number" name="first" required><br>
        Second Number: <input type="number" name="second" required><br>
        Operation:
        <select name="operation">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <br>
        <input type="submit" value="Calculate">
    </form>

    <h3>Answer is:
        <%
            String num1 = request.getParameter("first");
            String num2 = request.getParameter("second");
            String operation = request.getParameter("operation");
            if (num1 != null && num2 != null && operation != null) {
                try {
                    double first = Double.parseDouble(num1);
                    double second = Double.parseDouble(num2);
                    double result = 0;

                    switch (operation) {
                        case "+": result = first + second; break;
                        case "-": result = first - second; break;
                        case "*": result = first * second; break;
                        case "/":
                            if (second != 0) {
                                result = first / second;
                            } else {
                                out.println("Error: Division by zero is not allowed.");
                                return;
                            }
                            break;
                    }
                    out.println(result);
                } catch (NumberFormatException e) {
                    out.println("Error: Please enter valid numbers.");
                }
            }
        %>
    </h3>
</body>
</html>