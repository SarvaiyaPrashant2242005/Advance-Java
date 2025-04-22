<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Get user input from the request
    String username = request.getParameter("username");

    // Store value in session
    session.setAttribute("userSession", username);

    // Redirect to session display page
    response.sendRedirect("viewSession.jsp");
%>
