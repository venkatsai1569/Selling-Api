package com.example.helloworld.model;
public class Article {

    private String id;
    private String name;
    private int stock;

    // Constructor
    public Article(String id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

