package com.example.appbanhang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.appbanhang.R;
import com.example.appbanhang.ultil.DatalocalManager;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

if(!DatalocalManager.getFirstInstalled()) {
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(splashscreen.this, OnboardingActivity.class));
            DatalocalManager.setFirstInstalled(true);
        }
    }, 1000);
}else if(!DatalocalManager.getFirstInstalled2()){
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(splashscreen.this, LoginActivity.class));
            DatalocalManager.setFirstInstalled2(true);
        }
    }, 2000);
}else {
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(splashscreen.this, MainActivity.class));
        }
    }, 1000);
}
    }
}