package com.eoenesapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_screen);
    }

    public void onStartPress(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onQuitPress(View v)
    {
        finish();
    }
    public void onInfoPress(View v){
        Intent intent2 = new Intent(this, info.class);
        startActivity(intent2);
    }

    public void onHighScorePress(View v){
        Intent intentgameover = new Intent(this, takeTheLuke.class);
        startActivity(intentgameover);
    }

}
