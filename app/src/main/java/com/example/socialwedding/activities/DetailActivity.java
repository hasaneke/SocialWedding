package com.example.socialwedding.activities;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import com.example.socialwedding.R;
import com.example.socialwedding.adapter.CommentAdapter;
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
    private TextView descriptionTextView,likeTextView;
    String coupleName;
    String description;
    Button likeButton;
    private final ArrayList<CommentPost> commentsPosts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        r=new Random();
        int number=r.nextInt(9)+1;
       dummyList(number);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //baska bir activityden erşişitm ama herhangi bir işlem gerçekleştirilemiyor
      // View vi = inflater.inflate(R.layout.comment_layout, null); //log.xml is your file.
       // TextView likeTextView = (TextView)vi.findViewById(R.id.like_text_view);
       // Button likeButton=(Button)vi.findViewById(R.id.like_button);

       /* LinearLayout rl = (LinearLayout) findViewById(R.id.linear_layout);
        View vi = inflater.inflate(R.layout.comment_layout, null); //log.xml is your file.
        TextView tv = (TextView)vi.findViewById(R.id.like_text_view);
        Button likeButton=(Button)vi.findViewById(R.id.like_button);*/

       //likeButton=(Button)findViewById(R.layout.comment_layout);
       //likeTextView=(TextView)findViewById(R.id.like_text_view);

        ListView mListView = findViewById(R.id.comment_list_view);

        CommentAdapter adapter=new CommentAdapter(DetailActivity.this,commentsPosts);
        mListView.setAdapter(adapter);
        tv= (TextView)findViewById(R.id.tv);
        Intent intent=getIntent();
        coupleName=intent.getStringExtra("coupleNames");
        tv.setText(coupleName);
        description = intent.getStringExtra("description");
        descriptionTextView = findViewById(R.id.descriptiondetail);
        descriptionTextView.setText(description);


       /* likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //public static int parseInt(String s)
                likeButton.setBackgroundColor(Color.parseColor("#008000"));
                int likeNumber=Integer.parseInt(likeTextView.getText().toString());

                likeTextView.setText(++likeNumber);
            }
        });*/
    }

    private void dummyList(int number) {
        commentsPosts.add(new CommentPost(number,nameList[number],commentList[number],photoList[number]));
        commentsPosts.add(new CommentPost(1,nameList[1],commentList[1],photoList[1]));
        commentsPosts.add(new CommentPost(2,nameList[2],commentList[2],photoList[2]));
    }
}