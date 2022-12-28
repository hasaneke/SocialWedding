package com.example.socialwedding.models;

import com.example.socialwedding.R;

import org.json.JSONException;
import org.json.JSONObject;

public class WeddingPost {
    int id;
    String title;
    String body;
    int likeCount;
    int imageId;

    public WeddingPost(int id, String title, String body, int likeCount, int imageId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.likeCount = likeCount;
        this.imageId = imageId;
    }
    static public WeddingPost fromJsonObject(JSONObject json) throws JSONException {
        return new WeddingPost(json.getInt("id"),
                json.getString("title"),
                json.getString("body"),
                json.getInt("reactions"),
                R.drawable.wed4);
    }
    public int getId() {
        return id;
    }
    public String getTitle() {return title;}
    public String getDescription() {
        return body;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public int getImageId() {
        return imageId;
    }
}
