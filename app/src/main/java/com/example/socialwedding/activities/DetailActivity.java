package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import com.example.socialwedding.R;

public class DetailActivity extends AppCompatActivity {

    ImageView pp;
    Random r;
    String[] nameList={"Shane","Billy","Ariel","Jess","Kim","Alexis","Avery","Toby","Stacy","Riley"};
    String[] commentList={};
    int[] photoList={R.drawable.person1,R.drawable.person2,R.drawable.person3,R.drawable.person4,
            R.drawable.person5,R.drawable.person6,R.drawable.person7,R.drawable.person8,
            R.drawable.person9,R.drawable.person10};
    private String gelenCoupleNames;
    private int[] arr;
    private TextView tv,comment1;
    private TextView descriptionTextView;
    String coupleName;
    String description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv= (TextView)findViewById(R.id.tv);
        pp=(ImageView)findViewById(R.id.profile_photo);
        pp.setBackgroundResource(photoList[8]);
        r=new Random();

        comment1=(TextView)findViewById(R.id.name_text_view);

        comment1.setText("tebriklerrr supersniz<<");
        Intent intent=getIntent();
        coupleName=intent.getStringExtra("coupleNames");
        tv.setText(coupleName);
        description = intent.getStringExtra("description");
        descriptionTextView = findViewById(R.id.descriptiondetail);
        descriptionTextView.setText(description);
    }
}