package com.blogapp.dao;

import com.blogapp.model.Blog;
import com.blogapp.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {
    public void addBlog(Blog blog) throws SQLException {
        String sql = "INSERT INTO blogs (title, content, username) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getContent());
            ps.setString(3, blog.getUsername());
            ps.executeUpdate();
        }
    }



        public List<Blog> getAllBlogs() throws SQLException {
            List<Blog> blogs = new ArrayList<>();
            String sql = "SELECT id, title, content, username, published_at FROM blogs ORDER BY published_at DESC";

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Blog blog = new Blog(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("username"),
                            rs.getTimestamp("published_at")
                    );
                    blogs.add(blog);
                }
            }
            System.out.println("Blogs fetched from DB: " + blogs.size()); // Debugging
            return blogs;
        }
    }


