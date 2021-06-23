package com.example.geogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

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
        String [] file1 = read1();
        String [] file2 = read2();
        question.setText(file1[0]);
        counter.setText(file2[0]);
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

    public String[] read1() {
        String data = "";
        StringBuffer sbuffer = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.data1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String[] array = new String[0];
        if(is!=null){
            try{
                while((data = reader.readLine()) != null){
                    sbuffer.append((data + "///"));
                }
                String data1 = sbuffer.toString();
                array = data1.split("///");
                is.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    public String[] read2() {
        String data = "";
        StringBuffer sbuffer = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.data2);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String[] array = new String[0];
        if(is!=null){
            try{
                while((data = reader.readLine()) != null){
                    sbuffer.append((data + "///"));
                }
                String data1 = sbuffer.toString();
                array = data1.split("///");
                is.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    
}