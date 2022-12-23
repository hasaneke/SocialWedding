package com.example.socialwedding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.socialwedding.R;
import com.example.socialwedding.models.Post;

import java.util.ArrayList;

public class PostsAdapter extends ArrayAdapter<Post> implements View.OnClickListener{
    private ArrayList<Post> resource;
    Context context;
    public PostsAdapter(@NonNull Context context, ArrayList<Post> resource) {
        super(context, R.layout.post_layout, resource);
        this.resource = resource;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.post_layout,null);
        if(view!=null){
            TextView coupleNamesTextView = (TextView) view.findViewById(R.id.wedding_item_couple_names);
            TextView scoreTextView = (TextView) view.findViewById(R.id.wedding_item_score);
            TextView messagesTextView = (TextView) view.findViewById(R.id.wedding_item_messages);
            ImageView weddingImage = (ImageView) view.findViewById(R.id.wedding_item_imageView);

            coupleNamesTextView.setText(resource.get(position).title);
            scoreTextView.setText(resource.get(position).congrantsCount);
            messagesTextView.setText(resource.get(position).defination);
            weddingImage.setBackgroundResource(resource.get(position).imageId);

        }
        return view;
    }
}
