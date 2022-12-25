package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.socialwedding.R;
import com.example.socialwedding.adapter.PostsAdapter;
import com.example.socialwedding.database.DBAdapter;
import com.example.socialwedding.models.WeddingPost;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    PostsAdapter adapter;
    String[] coupleNames={"Ken and Barbie","Doc and Marty","Shrek and Donkey","Batman and Robin"};
Button share_button,exit_button;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    //private static final String KEY_NAME ="email";
    //private static final String KEY_EMAIL ="password";

    private final ArrayList<WeddingPost> posts = new ArrayList<>();
    final String dummyText = "Some dummy text for a long explanation " +
            "Some dummy text for a long explanation " +
            "Some dummy text for a long explanation " +
            "Some dummy text for a long explanation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        //initDummyData();
        share_button=(Button)findViewById(R.id.share_button) ;
        exit_button=(Button) findViewById(R.id.exit_button);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Toast.makeText(HomeActivity.this,"Exit Succesfully",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        DBAdapter db = new DBAdapter(this);
        db.open();
        //db.createTable();

        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed1);
        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed2);
        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed3);
        db.insertWedding("Murat Yıldırım","Shakira", "Mükemmel bir düğündü, Afrika``a taşınıyorum", 1258, R.drawable.wed4);

        // GET ALL WEDDINGS
        Cursor c = db.getAllWeddings();
        if (c.moveToFirst())
        {
            do {
                FetchWeddings(c);
            } while (c.moveToNext());
        }
        db.close();
        ListView mListView = findViewById(R.id.postsList);
        adapter = new PostsAdapter(getApplicationContext(), posts);
        mListView.setAdapter(adapter);
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