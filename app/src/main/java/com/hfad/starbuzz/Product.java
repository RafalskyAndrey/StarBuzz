package com.hfad.starbuzz;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String name;
    private String description;
    private int imageResourceId;

    public Product(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString(){
        return this.name;
    }
}
