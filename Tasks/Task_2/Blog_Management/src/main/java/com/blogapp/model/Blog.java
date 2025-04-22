package com.blogapp.model;

import java.sql.Timestamp;

public class Blog {
    private int id;
    private String title;
    private String content;
    private String username;
    private Timestamp publishedAt;

    // Constructor for fetching blogs from the database
    public Blog(int id, String title, String content, String username, Timestamp publishedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.publishedAt = publishedAt;
    }

    // Constructor for adding a new blog (without ID and timestamp)
    public Blog(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Timestamp getPublishedAt() { return publishedAt; }
    public void setPublishedAt(Timestamp publishedAt) { this.publishedAt = publishedAt; }
}
