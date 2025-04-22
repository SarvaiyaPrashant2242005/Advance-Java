<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Input</title>
</head>
<body>
    <h2>Enter Your Name</h2>
    <form action="sessionHandler.jsp" method="post">
        <label for="username">Name:</label>
        <input type="text" id="username" name="username" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
