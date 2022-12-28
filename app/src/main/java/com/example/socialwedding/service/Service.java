package com.example.socialwedding.service;

import android.os.AsyncTask;
import android.util.Log;

import com.example.socialwedding.models.WeddingPost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Service extends AsyncTask<URL, Integer, ArrayList<WeddingPost>> {
    @Override
    protected ArrayList<WeddingPost> doInBackground(URL... urls) {
       try{
           ArrayList<WeddingPost> weddingPosts = new ArrayList<>();
           HttpURLConnection con = (HttpURLConnection) urls[0].openConnection();
           con.setRequestMethod("GET");
           int responseCode = con.getResponseCode();
           System.out.println("GET Response Code :: " + responseCode);
           if (responseCode == HttpURLConnection.HTTP_OK) { // success
               BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
               String inputLine;
               StringBuffer response = new StringBuffer();
               while ((inputLine = in.readLine()) != null) {
                   response.append(inputLine);
               }
               JSONObject myResponse = new JSONObject(response.toString());
               JSONArray posts = myResponse.getJSONArray("posts");
                for(int i = 0; i<posts.length(); i++) {
                    weddingPosts.add(WeddingPost.fromJsonObject((JSONObject) posts.get(i)));
                }
               in.close();
               return  weddingPosts;
               // print result

           } else {
               System.out.println("GET request did not work.");
           }
       }catch (IOException exception) {
           exception.printStackTrace();
           return new ArrayList<>();
       } catch (JSONException e) {
           e.printStackTrace();
       }
        return new ArrayList<>();
    }
}
