<%@ page import="java.sql.*, java.text.*" %>
<jsp:include page="db.jsp" />
<%
    String uname = request.getParameter("username");
    String pwd = request.getParameter("password");
    Connection con = (Connection) application.getAttribute("dbConnection");

    PreparedStatement ps = con.prepareStatement("SELECT * FROM employee_master WHERE username=? AND password=?");
    ps.setString(1, uname);
    ps.setString(2, pwd);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        String lastAccess = rs.getString("last_access_time");

        // Store in session
        session.setAttribute("username", uname);
        session.setAttribute("lastAccessTime", lastAccess);

        // Update last access time
        PreparedStatement updateStmt = con.prepareStatement("UPDATE employee_master SET last_access_time=NOW() WHERE username=?");
        updateStmt.setString(1, uname);
        updateStmt.executeUpdate();

        response.sendRedirect("welcome.jsp");
    } else {
        out.println("<h3>Invalid Username or Password</h3>");
        out.println("<a href='login.jsp'>Try Again</a>");
    }
%>
