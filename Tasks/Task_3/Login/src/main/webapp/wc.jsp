<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    // Don't redeclare session — it's already available
    String user = (String)session.getAttribute("user");

    if(user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<html>
<head><title>Welcome</title></head>
<body>
    <h2>Welcome, <%= user %>!</h2>
    <p><a href="logout.jsp">Logout</a></p>
</body>
</html>
