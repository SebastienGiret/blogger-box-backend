package com.dauphine.blogger.dto;

import com.dauphine.blogger.models.Category;

import java.util.UUID;

public class CreationPostRequest {
    private String title;
    private String content;
    private UUID category_id;

    public CreationPostRequest() {}

    public CreationPostRequest(String title, String content, UUID category_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
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

    public UUID getCategory_id() {
        return category_id;
    }

    public void setCategory_id(UUID category_id) {
        this.category_id = category_id;
    }
}
