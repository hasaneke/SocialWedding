package com.example.socialwedding.models;

public class Post {
    public int imageId;
    public String title;
    public String defination;
    public String congrantsCount;

    public Post(int imageId, String title, String defination, String congrantsCount){
        this.imageId=imageId;
        this.title=title;
        this.defination=defination;
        this.congrantsCount=congrantsCount;
    }

}
