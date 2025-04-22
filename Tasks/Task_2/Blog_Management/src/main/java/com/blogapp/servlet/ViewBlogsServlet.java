package com.blogapp.servlet;

import com.blogapp.dao.BlogDAO;
import com.blogapp.model.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/viewBlogs")
public class ViewBlogsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BlogDAO blogDAO = new BlogDAO();
        try {
            List<Blog> blogs = blogDAO.getAllBlogs();
            System.out.println("Blogs fetched: " + blogs.size()); // Debugging output
            request.setAttribute("blogs", blogs);
            request.getRequestDispatcher("view-blogs.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(); // Print error log
            throw new ServletException("Error fetching blogs", e);
        }
    }
}
