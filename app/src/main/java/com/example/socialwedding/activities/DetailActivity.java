package com.example.socialwedding.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import com.example.socialwedding.R;
import com.example.socialwedding.models.CommentPost;
import com.example.socialwedding.models.WeddingPost;

public class DetailActivity extends AppCompatActivity {

    ImageView pp;
    Random r;
    String[] nameList={"Shane","Billy","Ariel","Jess","Kim","Alexis","Avery","Toby","Stacy","Riley"};
    String[] commentList={"Wishing you a lifetime of love and happiness.",
            "Your wedding day will come and go, but may your love forever grow.",
            "Best wishes on this wonderful journey, as you build your new lives together.",
            "May the years ahead be filled with lasting joy.",
            "May the true love you share today grow stronger as you grow old together.",
            "May your joining together bring you more joy than you can imagine.",
            "May today be the beginning of a long, happy life together.",
            "May the love and happiness you feel today shine through the years.",
            "So happy to celebrate this special day with you both!",
            "Congratulations—your wedding successfully made me sob like a baby!"};
    int[] photoList={R.drawable.person1,R.drawable.person2,R.drawable.person3,R.drawable.person4,
            R.drawable.person5,R.drawable.person6,R.drawable.person7,R.drawable.person8,
            R.drawable.person9,R.drawable.person10};
    private String gelenCoupleNames;
    private int[] arr;
    private TextView tv,commentTextView,nameTextView;
    private TextView descriptionTextView;
    String coupleName;
    String description;
    private final ArrayList<CommentPost> commentsPosts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        commentsPosts.add(new CommentPost(0,nameList[0],commentList[0],photoList[0]));
        commentsPosts.add(new CommentPost(1,nameList[1],commentList[1],photoList[1]));
        commentsPosts.add(new CommentPost(2,nameList[2],commentList[2],photoList[2]));
        ListView mListView = findViewById(R.id.comment_list_view);
       // mListView.setAdapter(loadDatabase());
        //mListView.setAdapter();
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,liste);

        ArrayAdapter<CommentPost> adapter=new ArrayAdapter<CommentPost>(this, android.R.layout.simple_list_item_1);

        mListView.setAdapter(adapter);


        r=new Random();
        int number=r.nextInt(9)+1;
        tv= (TextView)findViewById(R.id.tv);
        pp=(ImageView)findViewById(R.id.profile_photo);
        //pp.setBackgroundResource(photoList[number]);
        commentTextView=(TextView)findViewById(R.id.comment_text_view);
        //commentTextView.setText(commentList[number]);
        nameTextView=(TextView)findViewById(R.id.name_text_view);
        //nameTextView.setText(nameList[number]);

        Intent intent=getIntent();
        coupleName=intent.getStringExtra("coupleNames");
        tv.setText(coupleName);
        description = intent.getStringExtra("description");
        descriptionTextView = findViewById(R.id.descriptiondetail);
        descriptionTextView.setText(description);


    }


}