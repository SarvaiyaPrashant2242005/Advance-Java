<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.blogapp.model.Blog" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Blogs</title>
</head>
<body>
    <h1>All Blogs</h1>

    <%
        List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");
        if (blogs != null && !blogs.isEmpty()) {
            for (Blog blog : blogs) {
    %>
                <h2><%= blog.getTitle() %></h2>
                <p><%= blog.getContent() %></p>
                <small>By <%= blog.getUsername() %> on <%= blog.getPublishedAt() %></small>
                <hr>
    <%
            }
        }
    %>
</body>
</html>
