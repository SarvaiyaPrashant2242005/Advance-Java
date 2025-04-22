<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    // Dummy user credentials
    if("prashant".equals(user) && "admin123".equals(pass)) {
        // No need to redeclare session
        session.setAttribute("user", user);

        // Create a cookie
        Cookie cookie = new Cookie("user", user);
        cookie.setMaxAge(60*60); // 1 hour
        response.addCookie(cookie);

        // Forward to welcome.jsp using RequestDispatcher
        RequestDispatcher rd = request.getRequestDispatcher("wc.jsp");
        rd.forward(request, response);
    } else {
        // Redirect to error page
        response.sendRedirect("error.jsp");
    }
%>
