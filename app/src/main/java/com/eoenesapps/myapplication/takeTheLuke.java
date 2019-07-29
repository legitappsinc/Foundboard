package com.eoenesapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.eoenesapps.myapplication.MainActivity.score;

public class takeTheLuke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_the_luke);

    }
    @Override
    protected void onStart(){
        super.onStart();
            if(android.os.Build.VERSION.SDK_INT == 28) {
              TextView tx = (TextView) findViewById(R.id.gameover);
              Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/packdudenocopyright.ttf");
              tx.setTypeface(custom_font);

            }
            else{
                //add fancy image here
                System.out.println("Dang dude u should update");
                ImageView imageView = findViewById(R.id.gameOverImage);
                imageView.setVisibility(View.VISIBLE);
            }
        TextView finalscore = findViewById(R.id.finalScoreText);
        finalscore.setText("Final Score: " + Integer.toString(score));
    }

    public void takeTheLukePerra(View view){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);


    }




}

