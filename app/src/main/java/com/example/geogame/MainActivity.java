package com.example.geogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqldb=null;
    String Question,CorrectCountry,FalseQuestion1,FalseQuestion2,FalseQuestion3,trueAnswer;
    Random rand;
    Button startb,button1,button2,button3,nextb;
    TextView question, counter;
    Integer count=0;
    ArrayList<String> questionsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand =new Random(System.currentTimeMillis());
        getViewsReferences();
        enableButtons(false);
    }

    private void  getViewsReferences(){
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        startb=findViewById(R.id.startb);
        nextb=findViewById(R.id.nextb);
        counter=findViewById(R.id.counter);
        question=findViewById(R.id.question);
    }

    private void enableButtons(boolean enable) {
        button1.setEnabled(enable);
        button2.setEnabled(enable);
        button3.setEnabled(enable);
        nextb.setEnabled(enable);
    }

    
}