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
        }
    }, 1000);
}
if(!DatalocalManager.getFirstInstalled2()){
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(splashscreen.this, LoginActivity.class));
        }
    }, 2000);

}

        if(DatalocalManager.getFirstInstalled3()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(splashscreen.this, MainActivity.class));
                }
            }, 2000);

        }

    }
}