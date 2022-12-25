package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.socialwedding.R;

public class DetailActivity extends AppCompatActivity {

    private String gelenCoupleNames;
    private int[] arr;
    private TextView tv;
    private TextView descriptionTextView;
    String coupleName;
    String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv= (TextView)findViewById(R.id.tv);
        Intent intent=getIntent();
        coupleName=intent.getStringExtra("coupleNames");
        tv.setText(coupleName);
        description = intent.getStringExtra("description");
        descriptionTextView = findViewById(R.id.descriptiondetail);
        descriptionTextView.setText(description);
    }
}