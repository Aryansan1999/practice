package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {
LottieAnimationView sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        sp = findViewById(R.id.animationView);
          new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), authentication.class);
            startActivity(intent);
            finish();
        }, 4000);
    }
}