package com.example.socialwedding.models;

public class WeddingPost {
    int id;
    String husband;
    String wife;
    String description;
    int likeCount;
    int imageId;

    public WeddingPost(int id, String husband, String wife, String description, int likeCount, int imageId) {
        this.id = id;
        this.husband = husband;
        this.wife = wife;
        this.description = description;
        this.likeCount = likeCount;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public String getHusband() {
        return husband;
    }

    public String getWife() {
        return wife;
    }

    public String getDescription() {
        return description;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getImageId() {
        return imageId;
    }
}
