package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.socialwedding.R;
import com.example.socialwedding.database.DBAdapter;

public class SharePostActivity extends AppCompatActivity {
    EditText manET;
    EditText womanET;
    Button shareBTN;
    EditText descriptionET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_post);
        manET = findViewById(R.id.man);
        womanET = findViewById(R.id.woman);
        descriptionET = findViewById(R.id.description);
        shareBTN = findViewById(R.id.sharepost);
        DBAdapter dbAdapter = new DBAdapter(getApplicationContext());
        shareBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.open();
                dbAdapter.insertWedding(manET.getText().toString(),womanET.getText().toString(),
                        descriptionET.getText().toString(),
                        1258,
                        R.drawable.wed1);
                Intent intent = new Intent(SharePostActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}