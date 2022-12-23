package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.socialwedding.R;
import com.example.socialwedding.adapter.PostsAdapter;
import com.example.socialwedding.models.Post;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    PostsAdapter adapter;

    private final ArrayList<Post> postArray = new ArrayList<>();
    final String dummyText = "Some dummy text for a long explanation " +
            "Some dummy text for a long explanation " +
            "Some dummy text for a long explanation " +
            "Some dummy text for a long explanation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        initDummyData();
        ListView mListView = findViewById(R.id.postsList);
        adapter = new PostsAdapter(getApplicationContext(), postArray);
        mListView.setAdapter(adapter);
    }

    private void initDummyData () {
        postArray.add(new Post(R.drawable.wed1,"Ken and Barbie",dummyText,"congrats 12"));
        postArray.add(new Post(R.drawable.wed1,"Ken and Barbie",dummyText,"congrats 12"));
        postArray.add(new Post(R.drawable.wed1,"Ken and Barbie","waaaaow","congrats 12"));
        postArray.add(new Post(R.drawable.wed1,"Ken and Barbie","waaaaow","congrats 12"));
    }
}