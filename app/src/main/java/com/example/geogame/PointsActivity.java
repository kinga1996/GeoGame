package com.example.geogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import java.text.BreakIterator;

public class PointsActivity extends AppCompatActivity {

    static final String r_username = "player";
    String username;
    static final String r_usernames = "player";
    String usernames;
    static final String r_points = "0";
    String points = "0";
    static final String r_allpoints = "0";
    String allpoints = "0";

    TextView tv_scores;
    String[] tab_players = new String[0];
    String[] tab_points = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //username = prefs.getString(r_username, "player");
        //usernames = prefs.getString(r_usernames, "player");
        //points = prefs.getString(r_points, "0");
        //allpoints = prefs.getString(r_allpoints, "0");
        //tv_scores=findViewById(R.id.tscores);
        //createScores();
    }

    /*public void createScores(){
        tab_players = r_usernames.split(",");
        tab_points = r_allpoints.split(",");
        tv_scores.setText(tab_players[0]);
    }*/

}