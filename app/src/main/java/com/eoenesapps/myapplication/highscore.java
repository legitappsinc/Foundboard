package com.eoenesapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class highscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("High Score", MainActivity.score);

        if(MainActivity.score > sharedPreferences.getInt("High Score",MainActivity.score)){
        editor.commit();}

        TextView textView = findViewById(R.id.highScoreBoi);
        int integer = sharedPreferences.getInt("High Score",MainActivity.score);
        String holder = Integer.toString(integer);
        textView.setText(holder);


    }

    public void onHighScorePress(View view) {
        Intent intent = new Intent(this, highscore.class);
        startActivity(intent);
    }
}
