<%@ page import="com.parkingManagement.model.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // Check if session exists, else redirect to login page
    Users user = (Users) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("SignIn-page.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Park Vehicle</title>
</head>
<body>
    <h2>Vehicle Parking Form</h2>

    <form action="ParkingServlet" method="post">
        <input type="hidden" name="action" value="add"> <!-- Action type for servlet -->

        <label>Vehicle Number:</label>
        <input type="text" name="vehicleNumber" required><br><br>

        <label>Duration (minutes):</label>
        <input type="number" name="duration" required><br><br>

        <label>Entry Time:</label>
        <input type="datetime-local" name="entryTime" required><br><br>

        <!-- Hidden input for company name (stored as per database field) -->
        <input name="companyName" value="<%= user.getCompanyName() %>">

        <!-- Exit time is initially NULL, so it won't be included in the form -->

        <!-- Fine is default 0.0 and will be managed via backend logic -->

        <input type="submit" value="Park Vehicle">
    </form>
</body>
</html>
