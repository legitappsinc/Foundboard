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


        //USE IF STATEMENTS AND OTHER LOGIC TO SORT SCORES AND SAVE THEM IN SEPARATE SHAREDPREFS IDS, SO HIGH SCORE
        // NUMBER TWO CAN BE editor.putInt("High Score 2" etc. and we can save up to 5 high scores from HighScoreBoi to HighScoreBoi5

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("High Score 5", MainActivity.score);

        if (MainActivity.score > sharedPreferences.getInt("High Score 1", 0)) {
            {
                editor.putInt("High Score 5", sharedPreferences.getInt("High Score 4", 0));
                editor.putInt("High Score 4", sharedPreferences.getInt("High Score 3", 0));
                editor.putInt("High Score 3", sharedPreferences.getInt("High Score 2", 0));
                editor.putInt("High Score 2", sharedPreferences.getInt("High Score 1", 0));}
                editor.putInt("High Score 1", MainActivity.score);
    }
            else if (MainActivity.score > sharedPreferences.getInt("High Score 2", 0)) {
                editor.putInt("High Score 5", sharedPreferences.getInt("High Score 4", 0));
                editor.putInt("High Score 4", sharedPreferences.getInt("High Score 3", 0));
                editor.putInt("High Score 3", sharedPreferences.getInt("High Score 2", 0));
                editor.putInt("High Score 2", MainActivity.score);
            }

        else if (MainActivity.score > sharedPreferences.getInt("High Score 3", 0)) {
            editor.putInt("High Score 5", sharedPreferences.getInt("High Score 4", 0));
            editor.putInt("High Score 4", sharedPreferences.getInt("High Score 3", 0));
            editor.putInt("High Score 3", MainActivity.score);
        }

        else if (MainActivity.score > sharedPreferences.getInt("High Score 4", 0)) {
            editor.putInt("High Score 5", sharedPreferences.getInt("High Score 4", 0));
            editor.putInt("High Score 4", MainActivity.score);
        }

        else if (MainActivity.score > sharedPreferences.getInt("High Score 5", 0)) {
            editor.putInt("High Score 5", MainActivity.score);
        }
        
if (sharedPreferences.getInt("High Score 1", 0) >= sharedPreferences.getInt("High Score 2", 0) && sharedPreferences.getInt("High Score 2", 0) >= sharedPreferences.getInt("High Score 3", 0) && sharedPreferences.getInt("High Score 3", 0) >= sharedPreferences.getInt("High Score 4", 0) && sharedPreferences.getInt("High Score 4", 0) >= sharedPreferences.getInt("High Score 5", 0)) {
    editor.commit();
}
else{System.out.println("Something broke.... glhf #TakeTheLuke");
    editor.putString("High Score 5", "No Score");
    editor.putString("High Score 4", "No Score");
    editor.putString("High Score 3", "No Score");
    editor.putString("High Score 2", "No Score");
    editor.putString("High Score 1", "No Score");
    editor.commit();
}

        TextView textView = findViewById(R.id.highScoreBoi);
        int integer = sharedPreferences.getInt("High Score 1",MainActivity.score);
        String holder = Integer.toString(integer);
        textView.setText("1. " + holder);

        TextView textView2 = findViewById(R.id.highScoreBoi2);
        int integer2 = sharedPreferences.getInt("High Score 2",MainActivity.score);
        String holder2 = Integer.toString(integer2);
        textView2.setText("2. " + holder2);

        TextView textView3 = findViewById(R.id.highScoreBoi3);
        int integer3 = sharedPreferences.getInt("High Score 3",MainActivity.score);
        String holder3 = Integer.toString(integer3);
        textView3.setText("3. " + holder3);

        TextView textView4 = findViewById(R.id.highScoreBoi4);
        int integer4 = sharedPreferences.getInt("High Score 4",MainActivity.score);
        String holder4 = Integer.toString(integer4);
        textView4.setText("4. " + holder4);

        TextView textView5 = findViewById(R.id.highScoreBoi5);
        int integer5 = sharedPreferences.getInt("High Score 5",MainActivity.score);
        String holder5 = Integer.toString(integer5);
        textView5.setText("5. " + holder5);


    }

    public void onHighScorePress(View view) {
        Intent intent = new Intent(this, highscore.class);
        startActivity(intent);
    }
}
