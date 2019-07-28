package com.eoenesapps.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public int list[] =
            {R.raw.doorknock, R.raw.heavyrain, R.raw.morsecode, R.raw.spaceship};
    public String list2[] =
            {"Door Knocking", "Heavy Rain", "Morse Code", "Spaceship"};


    Random r = new Random();
    //String myArray[] = getResources().getStringArray(R.array.ids);
    //tried to use the array in raw arrays.xml but it wouldn't convert
    int randomNumber = r.nextInt(list.length);
    static int i;
    static String i2;
    static int score;
    public boolean gameOver;
    MediaPlayer mediaPlayer;
    public static int replayCounter = 4;

    protected void onStart() {
        replayCounter=4;
        score = 0;
        super.onStart();

        Button buttonreplay = findViewById(R.id.buttonReplay);
        buttonreplay.setText("Replay x5");

        //Keeps loop running

        gameOver = false;


        //Use loops to do this repeatedly


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
        mediaPlayer = MediaPlayer.create(this, i); //Placeholder file, change heavyrain to change what sound file it's playing
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(list[randomNumber]);
        mediaPlayer.start();


    }



    @Override
    public void onClick(View v){
            Button buttonA = (Button) findViewById(R.id.buttonA);
            buttonA.setOnClickListener(this);
            Button buttonB = (Button) findViewById(R.id.buttonB);
            buttonB.setOnClickListener(this);
            Button buttonC = (Button) findViewById(R.id.buttonC);
            buttonC.setOnClickListener(this);
            Button buttonD = (Button) findViewById(R.id.buttonD);
            buttonD.setOnClickListener(this);



            //Determine if button's been pressed or not
            switch (v.getId()) {

                case R.id.buttonA:
                    if (buttonA.getText() == i2) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();

                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();


                    }
                    break;

                case R.id.buttonB:
                    if (buttonB.getText() == i2) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();


                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();

                    }
                    break;

                case R.id.buttonC:
                    if (buttonC.getText() == i2) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();

                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();

                    }
                    break;
                case R.id.buttonD:
                    if (buttonD.getText() == i2) {
                        score+=1;
                        TextView textView = findViewById(R.id.score);
                        textView.setText("Score: " + Integer.toString(score));

                        placeHolder();

                    } else {
                        Intent intent = new Intent(this, takeTheLuke.class);
                        startActivity(intent);
                        mediaPlayer.stop();
                        mediaPlayer.release();

                    }
                    break;
                default:
                    break;
            }

        }

    public void replayButton(View v){

        Button button = findViewById(R.id.buttonReplay);
        button.setText("Replay x" + replayCounter);
        if(replayCounter!=0){
            replayCounter-=1;
            playSound();
    }
    else{
            button.setText("No Replays Left :(");
        }
    }

    public void playSound() {
        mediaPlayer.stop();
        mediaPlayer.release();
        //Place music files in file called raw, then after that the name of the file
         mediaPlayer = MediaPlayer.create(this, i); //Placeholder file, change heavyrain to change what sound file it's playing
        mediaPlayer.start(); }

    public void placeHolder() { //Causes the app to function more than once
        mediaPlayer.stop();
        mediaPlayer.release();

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

        chosenButtonA.setText(list2[randomNumber]);
        chosenButtonB.setText(list2[randomNumber2]);
        chosenButtonC.setText(list2[randomNumber3]);
        chosenButtonD.setText(list2[randomNumber4]);
        i = list[randomNumber];
        i2 = list2[randomNumber];
        mediaPlayer = MediaPlayer.create(getBaseContext(), i); //Placeholder file, change heavyrain to change what sound file it's playing
        mediaPlayer.start();

    }



    public void onQuitPress(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to quit?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                Html.fromHtml("<font color='#FF0000'>Exit this great app</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        System.exit(0);
                        moveTaskToBack(true);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                Html.fromHtml("<font color='#000000'>Stay here</font>"),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "Thanks for staying!", Toast.LENGTH_SHORT).show();
                        dialog.cancel();

                    }
                });

        AlertDialog alert11 = builder1.create();

        alert11.show();

    }}













