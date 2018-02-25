package com.example.c4q.finalexam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BreedActivity extends AppCompatActivity {
    private SharedPreferences login;
    private static final String SHARED_PREFS_KEY = "sharedPrefsTesting";
    private TextView welcomeView;
    private TextView terrier, spaniel, retriever, poodle;
    private ImageView tView,sVie,rView,pView;
    private ModelPuppy puppy;
    private CardView cardview1,cardView2,cardView3,cardview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed);

        welcomeView=findViewById(R.id.welcomView);
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        Intent i= getIntent();
        String user=i.getStringExtra("person");
        String sharePrefSvaed=login.getString("user"+user,null);
        if (sharePrefSvaed==null){
            Intent intent= new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
        welcomeView.setText("welcome," + " "+ sharePrefSvaed+ " " + "what kind of dog would you like to see"+ " " + sharePrefSvaed + " ?");
        Log.d("mainstuff", "onCreate: "+login.getString("user"+user,null));
        terrier=findViewById(R.id.terrier);
        spaniel=findViewById(R.id.spaniel);
        retriever=findViewById(R.id.retriever);
        poodle=findViewById(R.id.poodle);
        tView=findViewById(R.id.dogview);
        sVie=findViewById(R.id.dogview2);
        rView=findViewById(R.id.dogview3);
        pView=findViewById(R.id.dogview4);
        cardview1=findViewById(R.id.cardview1);
        cardView2=findViewById(R.id.cardview2);
        cardView3=findViewById(R.id.cardview3);
        cardview4=findViewById(R.id.cardview4);

        setUpTerrier(terrier.getText().toString());
        setUpSpaniel(spaniel.getText().toString());
        setUpretriever(retriever.getText().toString());
        setUppoodle(poodle.getText().toString());
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(BreedActivity.this,DogsActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("key",terrier.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(BreedActivity.this,DogsActivity.class);
                Bundle bundel= new Bundle();
                bundel.putString("key",spaniel.getText().toString());
                inte.putExtras(bundel);
                startActivity(inte);

            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inter=new Intent(BreedActivity.this,DogsActivity.class);
                Bundle bindel= new Bundle();
                bindel.putString("key",retriever.getText().toString());
                inter.putExtras(bindel);
                startActivity(inter);
            }
        });

        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intm= new Intent(BreedActivity.this, DogsActivity.class);
                Bundle bundl4= new Bundle();
                bundl4.putString("key",poodle.getText().toString());
                intm.putExtras(bundl4);
                startActivity(intm);

            }
        });







    }
    public void setUpTerrier(String name){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dog.ceo/").addConverterFactory(GsonConverterFactory.create())
                .build();
        BreedService service=retrofit.create(BreedService.class);
        Call<ModelPuppy> getBreed=service.getPuppies(name);
        getBreed.enqueue(new Callback<ModelPuppy>() {
            @Override
            public void onResponse(Call<ModelPuppy> call, Response<ModelPuppy> response) {
                puppy=response.body();
                String url=puppy.getMessage();
                Picasso.with(getApplicationContext())
                        .load(response.body().getMessage())
                        .into(tView);


            }

            @Override
            public void onFailure(Call<ModelPuppy> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }
    public void setUpSpaniel(String name){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dog.ceo/").addConverterFactory(GsonConverterFactory.create())
                .build();
        BreedService service=retrofit.create(BreedService.class);
        Call<ModelPuppy> getSpaniel=service.getPuppies(name);
        getSpaniel.enqueue(new Callback<ModelPuppy>() {
            @Override
            public void onResponse(Call<ModelPuppy> call, Response<ModelPuppy> response) {
                puppy=response.body();
                Picasso.with(getApplicationContext())
                        .load(response.body().getMessage())
                        .into(sVie);

            }

            @Override
            public void onFailure(Call<ModelPuppy> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }
    public void setUpretriever(String name){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dog.ceo/").addConverterFactory(GsonConverterFactory.create())
                .build();
        BreedService service=retrofit.create(BreedService.class);
        Call<ModelPuppy> getRetrieval=service.getPuppies(name);
        getRetrieval.enqueue(new Callback<ModelPuppy>() {
            @Override
            public void onResponse(Call<ModelPuppy> call, Response<ModelPuppy> response) {
                puppy=response.body();
                Picasso.with(getApplicationContext())
                        .load(response.body().getMessage())
                        .into(rView);

            }

            @Override
            public void onFailure(Call<ModelPuppy> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }
    public void setUppoodle(String name){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dog.ceo/").addConverterFactory(GsonConverterFactory.create())
                .build();
        BreedService service=retrofit.create(BreedService.class);
        Call<ModelPuppy> getPoodle=service.getPuppies(name);
        getPoodle.enqueue(new Callback<ModelPuppy>() {
            @Override
            public void onResponse(Call<ModelPuppy> call, Response<ModelPuppy> response) {
                puppy=response.body();
                Picasso.with(getApplicationContext())
                        .load(response.body().getMessage())
                        .into(pView);

            }

            @Override
            public void onFailure(Call<ModelPuppy> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }
}
