package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.socialwedding.MainActivity;
import com.example.socialwedding.R;
import com.example.socialwedding.adapter.PostsAdapter;
import com.example.socialwedding.models.Post;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    PostsAdapter adapter;
    String[] coupleNames={"Ken and Barbie","Doc and Marty","Shrek and Donkey","Batman and Robin"};

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
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("coupleNames",coupleNames[position]);
                startActivity(intent);

            }
        });
    }


    private void initDummyData () {
        postArray.add(new Post(R.drawable.wed1,coupleNames[0],dummyText,"congrats 12"));
        postArray.add(new Post(R.drawable.wed1,coupleNames[1],dummyText,"congrats 12"));
        postArray.add(new Post(R.drawable.wed1,coupleNames[2],"waaaaow","congrats 12"));
        postArray.add(new Post(R.drawable.wed1,coupleNames[3],"waaaaow","congrats 12"));
    }

}