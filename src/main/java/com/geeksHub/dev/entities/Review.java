package com.geeksHub.dev.entities;

import java.util.Date;

public class Review {

    public String id;
    public String body;
    public User user;
    public double rating;
    public Date creationTime;

    public Review ()
    {}

    public Review (String body, Date creationTime, double rating, User user){
        this.body = body;
        this.creationTime = creationTime;
        this.rating = rating;
        this.user = user;
    }


}