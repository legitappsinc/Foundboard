package com.eoenesapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.media.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);
    }

    int list[] =
        {R.raw.doorknock, R.raw.heavyrain, R.raw.morsecode, R.raw.spaceship};
    Random r = new Random();
    //String myArray[] = getResources().getStringArray(R.array.ids);
    //tried to use the array in raw arrays.xml but it wouldnt convert
    int randomNumber = r.nextInt(list.length);


    protected void onStart()
    {
        super.onStart();


        //Use loops to do this repeatedly
        int list[] =
                {R.raw.doorknock, R.raw.heavyrain, R.raw.morsecode, R.raw.spaceship};
        Random r = new Random();
        //String myArray[] = getResources().getStringArray(R.array.ids);
        //tried to use the array in raw arrays.xml but it wouldnt convert
        int randomNumber = r.nextInt(list.length);
        MediaPlayer mp = MediaPlayer.create(this, list[randomNumber]); //Placeholder file, change heavyrain to change what sound file it's playing
        mp.start();
    }




    public void playSound(View v) {
        //Place music files in file called raw, then after that the name of the file
       MediaPlayer mp = MediaPlayer.create(this, list[randomNumber]); //Placeholder file, change heavyrain to change what sound file it's playing
       mp.start();







   }




}


