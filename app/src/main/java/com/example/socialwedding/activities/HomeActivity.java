package com.example.socialwedding.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.socialwedding.MainActivity;
import com.example.socialwedding.R;
import com.example.socialwedding.adapter.PostsAdapter;
import com.example.socialwedding.database.CacheAdapter;
import com.example.socialwedding.database.DBAdapter;
import com.example.socialwedding.models.WeddingPost;
import com.example.socialwedding.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.net.URLConnection;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;

public class HomeActivity extends AppCompatActivity {
    String[] coupleNames={"Ken and Barbie","Doc and Marty","Shrek and Donkey","Batman and Robin"};
    Button share_button,exit_button;
    SharedPreferences sharedPreferences;
    SwipeRefreshLayout swipeRefreshLayout;
    private static final String SHARED_PREF_NAME="mypref";
    private  ArrayList<WeddingPost> posts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        exit_button = findViewById(R.id.exit_button);
        share_button = findViewById(R.id.share_button);
        swipeRefreshLayout = findViewById(R.id.refresh_id);
        ListView mListView = findViewById(R.id.postsList);

        posts = fetchPosts(mListView);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                fetchPosts(mListView);
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CacheAdapter.deleteUser();
                Toast.makeText(HomeActivity.this,"Exit Succesfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // RUN THE FIRST TIME DELETE AFTER
        // initDummyData(db);
        // GET ALL WEDDINGS
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("coupleNames",posts.get(position).getTitle());
                intent.putExtra("description", posts.get(position).getDescription());
                startActivity(intent);
            }
        });
        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SharePostActivity.class));
            }
        });
    }

    private ArrayList<WeddingPost> fetchPosts(ListView mListView) {
        try {
            AsyncTask<URL, Integer, ArrayList<WeddingPost>> posts;
            posts = new Service().execute(new URL("https://dummyjson.com/posts"));
            mListView.setAdapter(new PostsAdapter(getApplicationContext(), posts.get()));
            return posts.get();
        } catch (MalformedURLException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}