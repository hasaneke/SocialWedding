package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.socialwedding.R;
import com.example.socialwedding.RegisterPage;
import com.example.socialwedding.database.DBAdapter;

public class SharePostActivity extends AppCompatActivity {
    EditText manET;
    EditText womanET;
    Button shareBTN;
    EditText descriptionET;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_post);
        manET = findViewById(R.id.man);
        womanET = findViewById(R.id.woman);
        descriptionET = findViewById(R.id.description);
        shareBTN = findViewById(R.id.sharepost);
        mediaPlayer=MediaPlayer.create(this,R.raw.share_sound);
        DBAdapter dbAdapter = new DBAdapter(getApplicationContext());
        shareBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(manET.getText().toString().matches("") || womanET.getText().toString().matches("") || descriptionET.getText().toString().matches("")){
                    Toast.makeText(SharePostActivity.this,"Please enter all fields",Toast.LENGTH_SHORT).show();

                }
                else{
                    mediaPlayer.start();
                    dbAdapter.open();

                    Intent intent = new Intent(SharePostActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}