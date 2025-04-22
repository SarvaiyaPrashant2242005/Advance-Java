<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Processing</title>
</head>
<body>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if ("admin".equals(username) && "1234".equals(password)) {
        // set attribute and forward to page2.jsp
        request.setAttribute("username", username);
%>
        <jsp:forward page="Page2.jsp" />
<%
    } else {
%>
        <h3 style="color:red;">Invalid username or password. Try again.</h3>
        <a href="index.jsp">Back to Login</a>
<%
    }
%>

</body>
</html>
