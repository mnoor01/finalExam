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
    public void onBind(final ImageModel model){
        final int lengthView=model.getMessage().length;
        for (int i = 0; i < lengthView; i++) {
            final String pica=model.getMessage()[i];
            Picasso.with(itemView.getContext()).load(model.getMessage()[i]).into(puppyView);
            Log.d("viewholder", "onBind: "+model.getMessage()[i]);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(itemView.getContext().getApplicationContext(),PhotosActivity.class);
                   intent.putExtra("photoId",pica);
                   itemView.getContext().startActivity(intent);


                }
            });


        }

    }
}
