package com.example.c4q.finalexam.recyclerviewstuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.finalexam.ImageModel;
import com.example.c4q.finalexam.R;

/**
 * Created by c4q on 2/25/18.
 */

public class PuppyAdapter extends RecyclerView.Adapter<PuppyViewHolder> {
    private ImageModel model;

    public PuppyAdapter(ImageModel model) {
        this.model = model;
    }

    @Override
    public PuppyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View child = LayoutInflater.from(parent.getContext()).inflate(R.layout.puppy_itemview, parent, false);

        return new PuppyViewHolder(child);
    }

    @Override
    public void onBindViewHolder(PuppyViewHolder holder, int position) {
        holder.onBind(model);

    }

    @Override
    public int getItemCount() {
        return model.getMessage().length;
    }
}
