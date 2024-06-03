package com.dauphine.blogger.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created_date")
    private int created_date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Post() {}
    public Post(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
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

    public Category getCategory_id() {
        return category;
    }

    public void setCategory_id(Category category) { this.category = category; }
}
