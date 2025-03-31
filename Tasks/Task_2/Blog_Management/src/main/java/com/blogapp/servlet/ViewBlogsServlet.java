package com.blogapp;

import com.blogapp.dao.BlogDAO;
import com.blogapp.model.Blog;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view-blogs")
public class ViewBlogsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Blog> blogs = new BlogDAO().getAllBlogs();
        request.setAttribute("blogs", blogs);
        request.getRequestDispatcher("viewBlogs.jsp").forward(request, response);
    }
}
