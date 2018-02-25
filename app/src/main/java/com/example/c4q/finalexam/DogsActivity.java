package com.example.c4q.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DogsActivity extends AppCompatActivity {
    private TextView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);

        Intent intent= getIntent();

        nameView=findViewById(R.id.nameOfDog);
        String terriel= intent.getStringExtra("key");
        nameView.setText(terriel);


//        String spaniel= intent.getStringExtra("sStuff");
//        nameView.setText(spaniel);
//        String retrieval=intent.getStringExtra("rStuff");
//        nameView.setText(retrieval);


    }
}
