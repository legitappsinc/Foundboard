package com.eoenesapps.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class StartScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_screen);


    }
    public void onSettingsPress(View v)
    {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }
    public void onStartPress(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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


    }


    

    
    public void onInfoPress(View v){
        Intent intent2 = new Intent(this, info.class);
        startActivity(intent2);
    }

   public void onHighScorePress(View view){
        Intent intent3 = new Intent(this,highscore.class);
        startActivity(intent3);

   }

  }

    



