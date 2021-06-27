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
    static final String r_usernames = "player";
    String usernames;
    static final String r_points = "0";
    String points = "0";
    static final String r_allpoints = "0";
    String allpoints = "0";
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameters);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        username = prefs.getString(r_username, "player");
        usernames = prefs.getString(r_usernames, "player");
        points = prefs.getString(r_points, "0");
        allpoints = prefs.getString(r_allpoints, "0");
        TextView t_current_username = (TextView) findViewById(R.id.current_username);
        t_current_username.setText("Current username: " + username);
    }

    public void back(View v){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString(r_username, username);
        ed.putString(r_usernames, usernames);
        ed.putString(r_points, points);
        ed.putString(r_allpoints, allpoints);
        ed.commit();
        this.finish();
    }

    public void confirm_username(View v){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = prefs.edit();
        EditText e_current_username = findViewById(R.id.edit_username);
        TextView t_current_username = (TextView) findViewById(R.id.current_username);
        username = e_current_username.getText().toString();
        sb.append(usernames);
        sb.append(",");
        sb.append(username);
        ed.putString(r_usernames, sb.toString());
        sb2.append(allpoints);
        sb2.append(",");
        sb2.append(points);
        ed.putString(r_allpoints, sb2.toString());
        points = "0";
        usernames = prefs.getString(r_usernames, "player");
        allpoints = prefs.getString(r_allpoints, "0");
        t_current_username.setText("Current username: "+usernames);
    }
}
