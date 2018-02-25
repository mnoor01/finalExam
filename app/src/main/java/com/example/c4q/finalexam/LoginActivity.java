package com.example.c4q.finalexam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button submitButton;
    private SharedPreferences login;
    private static final String SHARED_PREFS_KEY = "sharedPrefsTesting";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.usernameID);
        password = findViewById(R.id.password);
        submitButton = findViewById(R.id.subButton);
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = login.edit();
                String stringUsername=username.getText().toString();
                String stringPassword=password.getText().toString();
                String checkUser = "user" + username.getText().toString();
                String checkPassword = "password" + username.getText().toString();

                if (username.getText() == null || password.getText()==null) {
                    username.setText("please enter username");
                    password.setText("please enter password");
                }
                else {
                    editor.putString(checkUser,username.getText().toString());
                    editor.putString(checkPassword,password.getText().toString());

                    editor.apply();
                }
                if (stringPassword.contains(stringUsername)){
                    password.setText("password can't contain username!");
                }


                if (username.getText().toString().equals(login.getString(checkUser,null))&&
                        password.getText().toString().equals(login.getString(checkPassword,null))){
                    Intent intent= new Intent(LoginActivity.this,BreedActivity.class);
                    intent.putExtra("person",username.getText().toString());
                    startActivity(intent);

                }






            }
        });

    }
}
