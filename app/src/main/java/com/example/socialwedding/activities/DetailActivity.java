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
String kelime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv= (TextView)findViewById(R.id.tv);


        Intent gelenIntent=getIntent();
        kelime=gelenIntent.getStringExtra("coupleNames");


        tv.setText(kelime);



    }
}