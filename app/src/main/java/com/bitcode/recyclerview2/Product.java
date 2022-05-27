package com.bitcode.recyclerview2;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String title;
    private int price;
    private int imageId;

    public Product(int id, String title, int price, int imageId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
