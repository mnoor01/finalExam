package com.example.c4q.finalexam.recyclerviewstuff;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.c4q.finalexam.ImageModel;
import com.example.c4q.finalexam.PhotosActivity;
import com.example.c4q.finalexam.R;
import com.squareup.picasso.Picasso;

/**
 * Created by c4q on 2/25/18.
 */

public class PuppyViewHolder extends RecyclerView.ViewHolder{
    public ImageView puppyView;
    public PuppyViewHolder(View itemView) {
        super(itemView);
        puppyView=itemView.findViewById(R.id.puppyiamge);
    }
    public void onBind( String dogUrl){
            Picasso.with(itemView.getContext())
                    .load(dogUrl).into(puppyView);


        }

    }

