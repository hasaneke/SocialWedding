package com.example.socialwedding.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.socialwedding.R;
import com.example.socialwedding.models.CommentPost;
import com.example.socialwedding.models.WeddingPost;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CommentAdapter extends ArrayAdapter<CommentPost> implements View.OnClickListener{

    final private ArrayList<CommentPost> resource;
    Context context;
    public CommentAdapter(@NonNull Context context, ArrayList<CommentPost> resource) {
       super(context,R.layout.comment_layout,resource);
        this.resource = resource;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.comment_layout,null);
        if(view!=null){
            TextView names=(TextView) view.findViewById(R.id.name_text_view) ;
            TextView comments=(TextView) view.findViewById(R.id.comment_text_view);
            ImageView profil_photo=(ImageView) view.findViewById(R.id.profile_photo);
            names.setText(resource.get(position).getName());
            comments.setText(resource.get(position).getComment());
           // profil_photo.setBackgroundResource(resource.get().g);


            profil_photo.setBackgroundResource(resource.get(position).getImageId());

        }
        return view;
    }
}
