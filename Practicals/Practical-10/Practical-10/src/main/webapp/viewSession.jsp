<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session Data</title>
</head>
<body>
    <h2>Session Information</h2>
    <%
        // Retrieve session value
        String user = (String) session.getAttribute("userSession");

        if (user != null) {
    %>
        <p>Welcome, <%= user %>!</p>
        <a href="logout.jsp">Logout</a>
    <%
        } else {
    %>
        <p>No active session found.</p>
        <a href="index.jsp">Go Back</a>
    <%
        }
    %>
</body>
</html>
