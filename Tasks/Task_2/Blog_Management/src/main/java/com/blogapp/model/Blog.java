package com.blogapp;

import java.sql.Timestamp;

public class Blog {
    private int id;
    private String title;
    private String content;
    private String username;
    private Timestamp publishedAt;

    public Blog(int id, String title, String content, String username, Timestamp publishedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
        this.publishedAt = publishedAt;
    }

    public Blog(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public Timestamp getPublishedAt() {
        return publishedAt;
    }
}
