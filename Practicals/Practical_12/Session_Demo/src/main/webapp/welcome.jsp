<%@ page import="java.util.*" %>
<%
    String uname = (String) session.getAttribute("username");
    if (uname == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<head><title>Welcome</title></head>
<body>
<h2>Welcome, <%= uname %></h2>

<%
    String last = (String) session.getAttribute("lastAccessTime");
    if (last != null) {
%>
    <p>Last Access Time: <%= last %></p>
<% } else { %>
    <p>This is your first login.</p>
<% } %>

<a href="logout.jsp">Logout</a>
</body>
</html>
