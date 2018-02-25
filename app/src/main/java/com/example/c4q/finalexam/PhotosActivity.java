package com.example.c4q.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PhotosActivity extends AppCompatActivity {
    private ImageView dogPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        Intent intent=getIntent();
        dogPhoto=findViewById(R.id.bigview);
        String id=intent.getStringExtra("photoId");

        Picasso.with(getApplicationContext()).load(id).into(dogPhoto);

    }
}
