<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Destroy session
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
