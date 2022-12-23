package com.example.socialwedding;

import static com.example.socialwedding.R.id.custom_listView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DiscoverWeddingPage extends AppCompatActivity {

    private ListView mListView;

    private WeddingAdapter adapter;
    private Post[] postArray={new Post(R.drawable.wed1,"Ken and Barbie","waaaaow","waaow"),
            new Post(R.drawable.wed1,"Ken and Barbie","waaaaow","waaow"),
            new Post(R.drawable.wed1,"Ken and Barbie","waaaaow","waaow"),
            new Post(R.drawable.wed1,"Ken and Barbie","waaaaow","waaow")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_listview);
        mListView=(ListView) findViewById(R.id.custom_listView);
        //coupleNames=getResources().getStringArray(R.array.coupleNamesArray);
        adapter=new WeddingAdapter(this,postArray);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),coupleNames[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}