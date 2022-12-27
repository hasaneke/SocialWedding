package com.example.socialwedding.models;

public class CommentPost {
    int id;
    String name;
    String comment;


    int imageId;

    public CommentPost(int id, String name, String comment, int imageId) {
        this.id = id;
        this.name=name;
        this.comment=comment;

        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }


    public int getImageId() {
        return imageId;
    }
}
