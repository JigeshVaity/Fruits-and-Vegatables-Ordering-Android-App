package com.example.fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fruits.fruitpage.MainActivity;
import com.example.fruits.login.entermobilenumberone;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(FirebaseUtil.isLoggedIn()){
                    startActivity(new Intent(Splashscreen.this, MainActivity.class));
                }else{
                    startActivity(new Intent(Splashscreen.this, entermobilenumberone.class));
                }


                finish();
            }
        },2500);
    }
}