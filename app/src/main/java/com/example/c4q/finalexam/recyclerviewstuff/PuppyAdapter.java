package com.example.c4q.finalexam.recyclerviewstuff;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.finalexam.ImageModel;
import com.example.c4q.finalexam.PhotosActivity;
import com.example.c4q.finalexam.R;

/**
 * Created by c4q on 2/25/18.
 */

public class PuppyAdapter extends RecyclerView.Adapter<PuppyViewHolder> {
    private String[] model;
    private Context context;

    public PuppyAdapter(Context context,String[]  model) {
        this.context=context;
        this.model = model;
    }

    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View child = LayoutInflater.from(parent.getContext()).inflate(R.layout.puppy_itemview, parent, false);

        return new PuppyViewHolder(child);
    }

    @Override
    public void onBindViewHolder(PuppyViewHolder holder, int position) {
        final String  pojo= model[position];
        holder.onBind(pojo);
        holder.puppyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, PhotosActivity.class);
                intent.putExtra("photoId",pojo);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return model.length;
    }
}
g