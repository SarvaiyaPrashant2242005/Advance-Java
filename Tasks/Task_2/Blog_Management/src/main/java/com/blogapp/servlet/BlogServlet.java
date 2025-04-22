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

@WebServlet("/blogs")
public class BlogServlet extends HttpServlet {
    private BlogDAO blogDAO;

    @Override
    public void init() {
        blogDAO = new BlogDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Blog> blogs = blogDAO.getAllBlogs();
            request.setAttribute("blogs", blogs);
            request.getRequestDispatcher("view-blogs.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error fetching blogs", e);
        }
    }
}
