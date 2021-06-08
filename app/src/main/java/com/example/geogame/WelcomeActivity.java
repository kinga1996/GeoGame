package com.example.geogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);
    }

    public void play(View v) {
        Intent a = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(a);
    }

    public void parameters(View v){
        Intent b = new Intent(WelcomeActivity.this, ParametersActivity.class);
        startActivity(b);
    }

    public void quit(View v){
        this.finish();
    }
}