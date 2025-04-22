<%@ page session="false" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form method="post" action="authenticate.jsp">
    Username: <input type="text" name="username" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
