<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Submit CV</title>
</head>
<body>
    <h2>Submit Your Details</h2>
    <form action="ConServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        Phone: <input type="text" name="phone" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
