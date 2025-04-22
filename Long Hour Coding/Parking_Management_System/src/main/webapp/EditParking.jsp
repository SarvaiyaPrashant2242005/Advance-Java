<%@ page import="com.parkingManagement.dao.ParkingDAO, com.parkingManagement.model.Parking" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    int parkingId = Integer.parseInt(request.getParameter("id"));
    ParkingDAO parkingDAO = new ParkingDAO();
    Parking parking = parkingDAO.getParkingById(parkingId);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Parking</title>
</head>
<body>
    <h2>Edit Parking Details</h2>
    <form action="ParkingServlet" method="post">
        <input type="hidden" name="id" value="<%= parking.getId() %>">
        Vehicle Number: <input type="text" name="vehicleNumber" value="<%= parking.getVehicleNumber() %>" required><br>
        Duration (mins): <input type="number" name="duration" value="<%= parking.getDuration() %>" required><br>
        <input type="hidden" name="action" value="update">
        <button type="submit">Update Parking</button>
    </form>
</body>
</html>
