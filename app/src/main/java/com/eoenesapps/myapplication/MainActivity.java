package com.eoenesapps.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
    //tried to use the array in raw arrays.xml but it wouldn't convert
    int randomNumber = r.nextInt(list.length);
    static int i;
    static String i2;
    static int score;
    public boolean gameOver;

    protected void onStart() {
        super.onStart();

        //Keeps loop running

        gameOver = false;


        //Use loops to do this repeatedly

        String list2[] =
                {"Door Knocking", "Heavy Rain", "Morse Code", "Spaceship"};
        int scoreKeeper;
        //Sets onClickListeners for each button
        Button buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(this);
        Button buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(this);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(this);
        Button buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(this);


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
        int randomNumber3 = r.nextInt(list2.length);
        int randomNumber4 = r.nextInt(list2.length);

        while (randomNumber2 == randomNumber || randomNumber2 == randomNumber3 || randomNumber2 == randomNumber4) {
            randomNumber2 = r.nextInt(list2.length);
        }


        while (randomNumber3 == randomNumber || randomNumber3 == randomNumber2 || randomNumber3 == randomNumber4) {
            randomNumber3 = r.nextInt(list2.length);
        }

        while (randomNumber4 == randomNumber || randomNumber4 == randomNumber2 || randomNumber4 == randomNumber3) {
            randomNumber4 = r.nextInt(list2.length);
        }

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


        //Statements to decide if the button pressed is the correct button


        //Media Player Object

        i = list[randomNumber];
        i2 = list2[randomNumber];
        MediaPlayer mp = MediaPlayer.create(this, i); //Placeholder file, change heavyrain to change what sound file it's playing
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(list[randomNumber]);
        mp.start();


    }



    @Override
    public void onClick(View v) {
        Button buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(this);
        Button buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(this);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(this);
        Button buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(this);
        switch (v.getId()) {

            case R.id.buttonA:
                if (buttonA.getText() == i2) {
                    score++;}

                else{
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                    }
                    break;

                    case R.id.buttonB:
                        if (buttonB.getText()==i2) {
                            score++;

                        } else {
                            Intent intent = new Intent(this, takeTheLuke.class);
                            startActivity(intent);
                        }
                        break;

                    case R.id.buttonC:
                        if (buttonC.getText()==i2) {
                            score++;

                        } else {
                            Intent intent = new Intent(this, takeTheLuke.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.buttonD:
                        if (buttonD.getText()==i2) {
                            score++;

                        } else {
                            Intent intent = new Intent(this, takeTheLuke.class);
                            startActivity(intent);
                        }
                        break;
                    default:
                        break;
                }
        }



    public void playSound(View v) {//Place music files in file called raw, then after that the name of the file
        MediaPlayer mp2 = MediaPlayer.create(this, i); //Placeholder file, change heavyrain to change what sound file it's playing
        mp2.start(); }

    /*public void onButtonPress(View view){

        if (.getText() == i2) {
            score++;}
        else{
            Intent intent = new Intent(this,takeTheLuke.class);
            startActivity(intent);
    }
}*/







}


