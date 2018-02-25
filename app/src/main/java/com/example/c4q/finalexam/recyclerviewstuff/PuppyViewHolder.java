package com.example.c4q.finalexam.recyclerviewstuff;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.c4q.finalexam.R;

/**
 * Created by c4q on 2/25/18.
 */

public class PuppyViewHolder extends RecyclerView.ViewHolder{
    private ImageView puppyView;
    public PuppyViewHolder(View itemView) {
        super(itemView);
        puppyView=itemView.findViewById(R.id.puppyiamge);
    }
}
