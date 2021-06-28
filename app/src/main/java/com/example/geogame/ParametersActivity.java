package com.example.geogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ParametersActivity extends AppCompatActivity {

    static final String r_username = "player";
    String username;
    static final String r_points = "0";
    String points = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameters);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        username = prefs.getString(r_username, "player");
        points = prefs.getString(r_points, "0");
        TextView t_current_username = (TextView) findViewById(R.id.current_username);
        t_current_username.setText("Current username: " + username);
        TextView t_current_points = (TextView) findViewById(R.id.current_points);
        t_current_points.setText("Your points: " + points);
    }

    public void back(View v){
        this.finish();
    }

    public void confirm_username(View v){
        EditText e_current_username = findViewById(R.id.edit_username);
        TextView t_current_username = (TextView) findViewById(R.id.current_username);
        TextView t_current_points = (TextView) findViewById(R.id.current_points);
        username = e_current_username.getText().toString();
        t_current_username.setText("Current username: "+username);
        String points = "0";
        t_current_points.setText("Your points: " + points);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString(r_username, username);
        ed.putString(r_points, "0");
        ed.commit();
    }
}
