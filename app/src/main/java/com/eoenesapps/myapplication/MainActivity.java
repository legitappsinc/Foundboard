package com.eoenesapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.media.*;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);
    }
//Placeholder

   public void playSound(View v) {
        //Place music files in file called raw, then after that the name of the file
       MediaPlayer mp = MediaPlayer.create(this, R.raw.heavyrain); //Placeholder file, change heavyrain to change what sound file it's playing
       mp.start();







   }




}


