<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.parkingManagement.model.Users" %>
<%
    // Check if session exists, else redirect to login page
    Users user = (Users) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("SignIn-page.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel - Vehicle Pricing</title>
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
    </style>
    <script>
        // Function to dynamically add vehicle pricing fields
        function addPricingFields() {
            var container = document.getElementById("pricing-items");
            var newItem = document.createElement("div");
            newItem.className = "pricing-item";

            newItem.innerHTML = `
                <input type="text" name="vehicle_type[]" placeholder="Vehicle Type" required>
                <input type="number" name="price[]" placeholder="Price" min="0" step="0.01" required>
                <input type="number" name="fine[]" placeholder="Fine Amount" min="0" step="0.01" required>
                <button type="button" onclick="this.parentElement.remove()">Remove</button>
            `;

            container.appendChild(newItem);
        }

        // Add first item when page loads
        window.onload = function() {
            addPricingFields();
        };
    </script>
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

    <div class="pricing-container">
        <h2 class="pricing-header">Vehicle Pricing Setup</h2>

        <form action="Vehicle" method="POST">
            <div class="pricing-table-header">
                <div class="pricing-item" style="background-color: #f2f2f2; font-weight: bold;">
                    <span style="flex: 1; padding: 0 8px;">Vehicle Type</span>
                    <span style="flex: 1; padding: 0 8px;">Parking Price (Per Day)</span>
                    <span style="flex: 1; padding: 0 8px;">Fine Amount (Per Day)</span>
                    <span style="width: 80px;"></span>
                </div>
            </div>

            <div id="pricing-items">
                <!-- Dynamic pricing items will be added here -->
            </div>

            <div class="button-row">
                <button type="button" class="add-button" onclick="addPricingFields()">Add Vehicle Type</button>
                <button type="submit" class="save-button">Save Pricing</button>
            </div>
        </form>
    </div>
</body>
</html>
