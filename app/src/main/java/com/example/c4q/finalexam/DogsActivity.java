package com.example.c4q.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

import com.example.c4q.finalexam.recyclerviewstuff.PuppyAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsActivity extends AppCompatActivity {
    private TextView nameView;
    private ImageModel model;
    private PuppyAdapter adapter;
    private String textFromTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);


        Intent intent = getIntent();

        nameView = findViewById(R.id.nameOfDog);
        String terriel = intent.getStringExtra("key");
        nameView.setText(terriel);
        textFromTv=nameView.getText().toString();
        setUpRetro(textFromTv);


//        String spaniel= intent.getStringExtra("sStuff");
//        nameView.setText(spaniel);
//        String retrieval=intent.getStringExtra("rStuff");
//        nameView.setText(retrieval);


    }

    public void setUpRetro(String name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/").addConverterFactory(GsonConverterFactory.create())
                .build();
        BreedService service = retrofit.create(BreedService.class);

        Call<ImageModel> getImages = service.getImage(name);
        getImages.enqueue(new Callback<ImageModel>() {
            @Override
            public void onResponse(Call<ImageModel> call, Response<ImageModel> response) {
                model = response.body();
                setUpRecyclerView();

            }

            @Override
            public void onFailure(Call<ImageModel> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }

    public void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.puppyRecyclerview);
        PuppyAdapter adapter= new PuppyAdapter(model);
        GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     switch(item.getItemId()){
            case R.id.logout_menu:
                Intent intent = new Intent(DogsActivity.this, LoginActivity.class);
                intent.putExtra("logout", true);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!textFromTv.equals("")){
            outState.putString("breedName", textFromTv);
        }
    }
}
//newer stuff
