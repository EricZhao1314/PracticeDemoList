package com.example.aoyi.liyepaltest;

/**
 * Created by aoyi on 2016/12/14.
 */

public class Book {
    private int id;
    private String author;
    private double price;
    private int psges;
    private String name;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPsges() {
        return psges;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPsges(int psges) {
        this.psges = psges;
    }

    public void setName(String name) {
        this.name = name;
    }
}
