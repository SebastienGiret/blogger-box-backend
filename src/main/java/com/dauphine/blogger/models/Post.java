package com.dauphine.blogger.models;

import java.util.UUID;

public class Post {
    private UUID id;
    private String title;
    private String content;
    private int created_date;
    private UUID category_id;

    public Post(String title, String content, UUID category_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreated_date() {
        return created_date;
    }

    public void setCreated_date(int created_date) {
        this.created_date = created_date;
    }

    public UUID getCategory_id() {
        return category_id;
    }

    public void setCategory_id(UUID category_id) {
        this.category_id = category_id;
    }
}
