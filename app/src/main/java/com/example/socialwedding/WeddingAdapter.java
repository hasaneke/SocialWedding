package com.example.socialwedding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeddingAdapter extends ArrayAdapter<String> {

    Post[] posts;
    private Context context;

    private TextView coupleNamesTextView, scoreTextView,messagesTextView;
    private ImageView weddingImage;


    public WeddingAdapter(Context context,Post[] posts){

        super(context,R.layout.wedding_items);
        this.posts=posts;

        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.wedding_items,null);
        if(view!=null){
            coupleNamesTextView=(TextView)view.findViewById(R.id.wedding_item_couple_names);
            scoreTextView=(TextView)view.findViewById(R.id.wedding_item_score);
            messagesTextView=(TextView)view.findViewById(R.id.wedding_item_messages);
            weddingImage=(ImageView)view.findViewById(R.id.wedding_item_imageView);

            coupleNamesTextView.setText(posts[position].title);
            scoreTextView.setText(posts[position].congrantsCount);
            messagesTextView.setText(posts[position].defination);
            weddingImage.setBackgroundResource(posts[position].imageId);

        }
        return view;
    }
}
