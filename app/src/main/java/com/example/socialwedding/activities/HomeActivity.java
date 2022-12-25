package com.example.socialwedding.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.socialwedding.R;
import com.example.socialwedding.adapter.PostsAdapter;
import com.example.socialwedding.database.CacheAdapter;
import com.example.socialwedding.database.DBAdapter;
import com.example.socialwedding.models.WeddingPost;

import java.util.ArrayList;
import java.util.Comparator;

public class HomeActivity extends AppCompatActivity {
    String[] coupleNames={"Ken and Barbie","Doc and Marty","Shrek and Donkey","Batman and Robin"};
    Button share_button,exit_button;
    SharedPreferences sharedPreferences;
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    private static final String SHARED_PREF_NAME="mypref";
    private final ArrayList<WeddingPost> posts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        exit_button = findViewById(R.id.exit_button);
        share_button = findViewById(R.id.share_button);
        swipeRefreshLayout = findViewById(R.id.refresh_id);
        ListView mListView = findViewById(R.id.postsList);
        mListView.setAdapter(loadDatabase());
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                mListView.setAdapter(loadDatabase());
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CacheAdapter.deleteUser();
                Toast.makeText(HomeActivity.this,"Exit Succesfully",Toast.LENGTH_SHORT).show();
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
                intent.putExtra("coupleNames",coupleNames[position]);
                startActivity(intent);
            }
        });
        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(HomeActivity.this, SharePostActivity.class));
            }
        });

    }
    private PostsAdapter loadDatabase() {
        DBAdapter db = new DBAdapter(this);
        db.open();
        Cursor c = db.getAllWeddings();
        posts.clear();
        if (c.moveToFirst())
        {
            do {
                FetchWeddings(c);
            } while (c.moveToNext());
        }
        db.close();
       return new PostsAdapter(getApplicationContext(), posts);
    }

    private void initDummyData(DBAdapter db) {
        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed1);
        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed2);
        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed3);
        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed4);
    }
    public void FetchWeddings(Cursor c)
    {
        posts.add(new WeddingPost(
                c.getInt(0),
                c.getString(1),
                c.getString(2),
                c.getString(3),
                c.getInt(4),
                c.getInt(5)));

    }
}