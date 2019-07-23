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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
        
        String list2[] =
                {"Door Knocking", "Heavy Rain", "Morse Code", "Spaceship"};
        int scoreKeeper;

        Button buttonA = findViewById(R.id.buttonA);
        Button buttonB = findViewById(R.id.buttonB);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonD = findViewById(R.id.buttonD);


        int list[] =
                {R.raw.doorknock, R.raw.heavyrain, R.raw.morsecode, R.raw.spaceship};
        
       /* ArrayList<Integer> integerArrayList2 = new ArrayList<>();
        integerArrayList2.add(R.raw.doorknock);
        integerArrayList2.add(R.raw.heavyrain);
        integerArrayList2.add(R.raw.morsecode);
        integerArrayList2.add(R.raw.spaceship);
        Collections.shuffle(integerArrayList2); */
        
        
        
        Random r = new Random();
        //String myArray[] = getResources().getStringArray(R.array.ids);
        //tried to use the array in raw arrays.xml but it wouldn't convert
        int randomNumber = r.nextInt(list2.length);
        int randomNumber2 = r.nextInt(list2.length);
        int randomNumber3= r.nextInt(list2.length);
        int randomNumber4 = r.nextInt(list2.length);

        while(randomNumber2 == randomNumber || randomNumber2 == randomNumber3 || randomNumber2 == randomNumber4)
        {randomNumber2 = r.nextInt(list2.length);}
        
        
        while(randomNumber3 == randomNumber || randomNumber3 == randomNumber2 || randomNumber3 == randomNumber4)
        {randomNumber3 = r.nextInt(list2.length);}
        
        while(randomNumber4 == randomNumber || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber3)
        {randomNumber4 = r.nextInt(list2.length);}

        ArrayList<Button> arrayList = new ArrayList<>();
        arrayList.add(buttonA);
        arrayList.add(buttonB);
        arrayList.add(buttonC);
        arrayList.add(buttonD);
        Collections.shuffle(arrayList);
        //Chosen button A is the button used in the main activity, completley random
        Button chosenButtonA = arrayList.get(0);
        Button chosenButtonB = arrayList.get(1);
        Button chosenButtonC = arrayList.get(2);
        Button chosenButtonD = arrayList.get(3);


        /*
        When more btns are added in the future add them into the lists.
         */




        //Sets the button text
        chosenButtonA.setText(list2[randomNumber]);
        chosenButtonB.setText(list2[randomNumber2]);
        chosenButtonC.setText(list2[randomNumber3]);
        chosenButtonD.setText(list2[randomNumber4]);



        //Media Player Object

        int i = list[randomNumber];
        MediaPlayer mp = MediaPlayer.create(this, i); //Placeholder file, change heavyrain to change what sound file it's playing
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(list[randomNumber]);
        mp.start();


    }




    public void playSound(View v) {
        //Place music files in file called raw, then after that the name of the file
       MediaPlayer mp = MediaPlayer.create(this, list[randomNumber]); //Placeholder file, change heavyrain to change what sound file it's playing
       mp.start();

   }




}


