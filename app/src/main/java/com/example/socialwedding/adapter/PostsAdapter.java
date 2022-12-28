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
import com.example.socialwedding.models.WeddingPost;

import java.util.ArrayList;

public class PostsAdapter extends ArrayAdapter<WeddingPost> implements View.OnClickListener{
    final private ArrayList<WeddingPost> resource;
    Context context;
    public PostsAdapter(@NonNull Context context, ArrayList<WeddingPost> resource) {
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
            TextView titleTextView = (TextView) view.findViewById(R.id.title);
            TextView scoreTextView = (TextView) view.findViewById(R.id.wedding_like_count);
            TextView bodyView = (TextView) view.findViewById(R.id.body);
            ImageView weddingImage = view.findViewById(R.id.wedding_item_image);
            titleTextView.setText(resource.get(position).getTitle());
            scoreTextView.setText(String.valueOf("like " + resource.get(position).getLikeCount()));
            bodyView.setText(resource.get(position).getDescription());
            weddingImage.setBackgroundResource(resource.get(position).getImageId());
        }
        return view;
    }
}
