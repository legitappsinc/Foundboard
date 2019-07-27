package com.eoenesapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    }

    public void takeTheLukePerra(View view){
        Intent intent = new Intent(this,StartScreen.class);
        startActivity(intent);


    }
}
