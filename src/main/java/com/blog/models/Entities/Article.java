package com.blog.models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false, updatable = false, unique = true)
    private int id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
