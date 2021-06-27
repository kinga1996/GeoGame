package com.example.geogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

    Button button1,button2,button3,button4,nextb,backb,scoresb;
    TextView tv_question,tv_username, tv_checkanswer, tv_points;
    Random random = new Random();
    int value = 0;
    static final String r_points = "0";
    int points = 0;
    static final String r_username = "player";
    String username;

    String[] file1 = new String[0];
    String[] file2 = new String[0];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViewsReferences();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        points = Integer.parseInt(prefs.getString(r_points, "0"));
        username = prefs.getString(r_username, "player");
        tv_username.setText("Player: " + username);
        tv_points.setText("Your points: " + String.valueOf(points));
        file1 = read1();
        file2 = read2();
        value = nextQuestion(file1, file2);
    }

    public void next(View v) {
        value = nextQuestion(file1, file2);
    }

    private void getViewsReferences(){
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        scoresb = findViewById(R.id.scoresb);
        nextb=findViewById(R.id.nextb);
        backb=findViewById(R.id.backb);
        tv_question=findViewById(R.id.question);
        tv_username=findViewById(R.id.player);
        tv_checkanswer=findViewById(R.id.checkanswer);
        tv_points=findViewById(R.id.points);
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

    public int nextQuestion(String[] file1, String[] file2){
        int lfile1 = file1.length; //CONTINENT, COORDINATES
        int lfile2 = file2.length; //COUNTRY, CAPITAL, POPULATION, CURRENCY
        int randomCorrect =  random.nextInt((lfile2-1) - 0) + 0;
        int randomButton =  random.nextInt(3 - 0) + 0;
        int randomType =  random.nextInt(5 - 0) + 0; //CAPITAL, POPULATION, CURRENCY, CONTINENT, COORDINATES
        int randomFalse[] = new int[3];
        do {
            randomFalse[0] = random.nextInt((lfile2 - 1) - 0) + 0;
        } while (randomFalse[0] == randomCorrect);
        do {
            randomFalse[1] = random.nextInt((lfile2 - 1) - 0) + 0;
        } while (randomFalse[1] == randomCorrect || randomFalse[1] == randomFalse[0] );
        do {
            randomFalse[2] = random.nextInt((lfile2 - 1) - 0) + 0;
        } while (randomFalse[2] == randomCorrect || randomFalse[2] == randomFalse[1] || randomFalse[2] == randomFalse[0] );
        String[] correct_file2 = file2[randomCorrect].split(":");
        String[] false1_file2 = file2[randomFalse[0]].split(":");
        String[] false2_file2 = file2[randomFalse[1]].split(":");
        String[] false3_file2 = file2[randomFalse[2]].split(":");
        String[] correct_file1 = new String[0];
        String[] false1_file1 = new String[0];
        String[] false2_file1 = new String[0];
        String[] false3_file1 = new String[0];
        for (int i = 0; i < lfile1; i++) {
            if (file1[i].contains(correct_file2[0])) {
                correct_file1 = file1[i].split(":");
                break;
            }
        }
        for (int i = 0; i < lfile1; i++) {
            if (file1[i].contains(false1_file2[0])) {
                false1_file1 = file1[i].split(":");
                break;
            }
        }
        for (int i = 0; i < lfile1; i++) {
            if (file1[i].contains(false2_file2[0])) {
                false2_file1 = file1[i].split(":");
                break;
            }
        }
        for (int i = 0; i < lfile1; i++) {
            if (file1[i].contains(false3_file2[0])) {
                false3_file1 = file1[i].split(":");
                break;
            }
        }
        String AnswerCorrect = "";
        String AnswerFalse1 = "";
        String AnswerFalse2 = "";
        String AnswerFalse3 = "";
        if (randomType == 0){ //CAPITOL
            tv_question.setText("What is the capital of " + correct_file2[0] + "?");
            AnswerCorrect = correct_file2[1];
            AnswerFalse1 = false1_file2[1];
            AnswerFalse2 = false2_file2[1];
            AnswerFalse3 = false3_file2[1];
        }
        if (randomType == 1){ //POPULATION
            tv_question.setText("What is the population of " + correct_file2[0] + "?");
            AnswerCorrect = correct_file2[2];
            AnswerFalse1 = false1_file2[2];
            AnswerFalse2 = false2_file2[2];
            AnswerFalse3 = false3_file2[2];
        }
        if (randomType == 2){ //CURRENCY
            tv_question.setText("What is the currency of " + correct_file2[0] + "?");
            AnswerCorrect = correct_file2[3];
            AnswerFalse1 = false1_file2[3];
            AnswerFalse2 = false2_file2[3];
            AnswerFalse3 = false3_file2[3];
        }
        if (randomType == 3){ //CONTINENT
            tv_question.setText("On which continent is " + correct_file2[0] + " located?");
            AnswerCorrect = correct_file1[4];
            AnswerFalse1 = false1_file1[4];
            AnswerFalse2 = false2_file1[4];
            AnswerFalse3 = false3_file1[4];

        }
        if (randomType == 4){ //COORDINATES
            tv_question.setText("What are the geographical coordinates of " + correct_file2[0] + "?");
            AnswerCorrect = correct_file1[2] + " " + correct_file1[3];
            AnswerFalse1 = false1_file1[2] + " " + false1_file1[3];
            AnswerFalse2 = false2_file1[2] + " " + false1_file1[3];
            AnswerFalse3 = false3_file1[2] + " " + false1_file1[3];
        }
        if(randomButton == 0){
            button1.setText(AnswerCorrect);
            button2.setText(AnswerFalse1);
            button3.setText(AnswerFalse2);
            button4.setText(AnswerFalse3);
        }
        if(randomButton == 1){
            button2.setText(AnswerCorrect);
            button1.setText(AnswerFalse1);
            button3.setText(AnswerFalse2);
            button4.setText(AnswerFalse3);
        }
        if(randomButton == 2){
            button3.setText(AnswerCorrect);
            button2.setText(AnswerFalse1);
            button1.setText(AnswerFalse2);
            button4.setText(AnswerFalse3);
        }
        if(randomButton == 3){
            button4.setText(AnswerCorrect);
            button2.setText(AnswerFalse1);
            button3.setText(AnswerFalse2);
            button1.setText(AnswerFalse3);
        }
        return randomButton;
    }

    public void Validate1(View v){
        if (value == 0) {
            tv_checkanswer.setText("Good!");
            points = points + 1;
            tv_points.setText("Your points: " + String.valueOf(points));
        }
        else tv_checkanswer.setText("Wrong!");
        nextQuestion(file1, file2);
    }

    public void Validate2(View v){
        if (value == 1) {
            tv_checkanswer.setText("Good!");
            points = points + 1;
            tv_points.setText("Your points: " + String.valueOf(points));
        }
        else tv_checkanswer.setText("Wrong!");
        nextQuestion(file1, file2);
    }

    public void Validate3(View v){
        if (value == 2) {
            tv_checkanswer.setText("Good!");
            points = points + 1;
            tv_points.setText("Your points: " + String.valueOf(points));
        }
        else tv_checkanswer.setText("Wrong!");
        nextQuestion(file1, file2);
    }

    public void Validate4(View v){
        if (value == 3) {
            tv_checkanswer.setText("Good!");
            points = points + 1;
            tv_points.setText("Your points: " + String.valueOf(points));
        }
        else tv_checkanswer.setText("Wrong!");
        nextQuestion(file1, file2);
    }

    public void scores(View v) {
        Intent a = new Intent(MainActivity.this, PointsActivity.class);
        startActivity(a);
    }

    public void back(View v){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString(String.valueOf(r_points), String.valueOf(points));
        ed.commit();
        this.finish();
    }

    
}