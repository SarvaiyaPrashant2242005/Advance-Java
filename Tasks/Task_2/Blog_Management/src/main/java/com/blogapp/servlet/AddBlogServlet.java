package com.blogapp;

import com.blogapp.dao.BlogDAO;
import com.blogapp.model.Blog;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-blog")
public class AddBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String username = request.getParameter("username");

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUsername(username);

        new BlogDAO().addBlog(blog);
        response.sendRedirect("view-blogs");
    }
}
