<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <%
        String user = (String) request.getAttribute("username");
    %>
    <h2>Welcome <%= user %>!</h2>
    <p>You have successfully logged in. page 2</p>
</body>
</html>
