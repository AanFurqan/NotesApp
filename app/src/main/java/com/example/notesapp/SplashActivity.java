package com.example.notesapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        pass = settings.getString("pass", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pass.equals("")){
                    //if there is no password
                    Intent intent = new Intent(getApplicationContext(), CreatePassActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    //if there is password
                    Intent intent = new Intent(getApplicationContext(), EnterPassActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 2000);
    }
}