<%@ page import="com.parkingManagement.model.Users, com.parkingManagement.model.Parking, com.parkingManagement.dao.ParkingDAO, java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // Check if session exists, else redirect to login page
    Users user = (Users) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("SignIn-page.jsp");
        return;
    }

    // Fetch parking details from database
    ParkingDAO parkingDAO = new ParkingDAO();
    List<Parking> parkingList = parkingDAO.getAllParkings(user.getCompanyName());
%>

<!DOCTYPE html>
<html>
<head>
    <title>Company Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #007bff;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .navbar .company-name {
            font-size: 22px;
            font-weight: bold;
        }
        .navbar .nav-buttons {
            display: flex;
        }
        .navbar .btn {
            padding: 10px 15px;
            margin-left: 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            color: white;
            font-size: 14px;
            text-decoration: none;
        }
        .add-vehicle { background-color: #28a745; }
        .add-parking { background-color: #17a2b8; }
        .logout-btn { background-color: red; }
        .btn:hover { opacity: 0.8; }
        .container {
            width: 80%;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        .action-btn {
            padding: 5px 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 14px;
        }
        .edit-btn { background-color: #ffc107; }
        .delete-btn { background-color: #dc3545; }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="company-name"><%= user.getCompanyName() %></div>
        <div class="nav-buttons">
            <a href="vehicles.jsp" class="btn add-vehicle">Add Vehicle</a>
            <a href="Parking.jsp" class="btn add-parking">Add Parking</a>
            <form action="logout" method="post" style="display: inline;">
                <button type="submit" class="btn logout-btn">Logout</button>
            </form>
        </div>
    </div>

    <div class="container">
        <h2>Parked Vehicles</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Vehicle Number</th>
                <th>Duration (mins)</th>
                <th>Entry Time</th>
                <th>Exit Time</th>
                <th>Fine</th>
                <th>Actions</th>
            </tr>
            <% for (Parking parking : parkingList) { %>
            <tr>
                <td><%= parking.getId() %></td>
                <td><%= parking.getVehicleNumber() %></td>
                <td><%= parking.getDuration() %></td>
                <td><%= parking.getEntryTime() %></td>
                <td><%= parking.getExitTime() != null ? parking.getExitTime() : "N/A" %></td>
                <td><%= parking.getFine() %></td>
                <td>
                    <a href="<%= parking.getId() %>" class="action-btn edit-btn">Edit</a>
                    <a href="ParkingServlet?action=delete&id=<%= parking.getId() %>" class="action-btn delete-btn" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>


