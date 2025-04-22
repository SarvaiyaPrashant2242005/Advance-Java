<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <form action="signup" method="post">
        Company Name: <input type="text" name="company_name" required><br>
        Email: <input type="email" name="company_email" required><br>
        Phone: <input type="text" name="company_phone" required><br>
        Address: <input type="text" name="company_address" required><br>
        Parking Slots: <input type="number" name="parking_slots" required><br>
        Password: <input type="password" name="password" required><br>
        <button type="submit">Sign Up</button>
    </form>
</body>
</html>
