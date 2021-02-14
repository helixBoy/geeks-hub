package com.geeksHub.dev.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "companies")
public class Company {
    public String id;
    public String name;
    public String address;
    public List<Review> reviews;
    public double rating;

    public Company (String name, String address){
        this.name = name;
        this.address  = address;
    }
}
