package com.eoenesapps.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;

import java.util.Objects;

import static com.eoenesapps.myapplication.MainActivity.arrayHolderBoi;
import static com.eoenesapps.myapplication.MainActivity.arrayNameHolderBoi;
import static com.eoenesapps.myapplication.MainActivity.bird2List;
import static com.eoenesapps.myapplication.MainActivity.birdList;
import static com.eoenesapps.myapplication.MainActivity.gameOver;
import static com.eoenesapps.myapplication.MainActivity.i;
import static com.eoenesapps.myapplication.MainActivity.i2;
import static com.eoenesapps.myapplication.MainActivity.list;
import static com.eoenesapps.myapplication.MainActivity.list2;
import static com.eoenesapps.myapplication.MainActivity.musical2Instruments;
import static com.eoenesapps.myapplication.MainActivity.musicalInstruments;
import static com.eoenesapps.myapplication.MainActivity.replayCounter;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

/*

ALL THE SETTINGS ARE SET UP!!
ALL YOU HAVE TO DO IS FINISH THE LIGHT/DARK THEME SWITCHER BELOW TO ACTUALLY MAKE IT SWITCH THEMES
YOU SHOULD SEE THE CODE EASILY, HARD TO MISS

LOOKS LIKE THIS:

if (switchPref == true) {
                //dark theme enabled, make sure you actually put code here so that if someone
                //switches back to dark theme from white it will change
            } else {
                //Enable white theme here
            }

OK THANKS
-Luke at 12am
 */

    public static final String
            THEME_SWITCH = "themekey";
    public static final String
            CHEATS_SWITCH = "cheatskey";
    public static final String
            PACK_SWITCH = "packType";
    public static boolean cheatsActivated = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
 //use comment buddy
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        } //Kotlin BOis



    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences  sharedPreferences, String key) {
        SharedPreferences sharedPref =
                androidx.preference.PreferenceManager
                        .getDefaultSharedPreferences(this);
            boolean switchPref = sharedPref.getBoolean
                    (SettingsActivity.THEME_SWITCH, true);
            boolean cheatsPref = sharedPref.getBoolean
                    (SettingsActivity.CHEATS_SWITCH, false);

            if (switchPref == true) {
                //dark theme enabled, make sure you actually put code here so that if someone
                //switches back to dark theme from white it will change
            } else {
                //Enable white theme here
            }

            if (cheatsPref == true) {
                //Button buttonA = R.id.buttonA;
                cheatsActivated = true;
                Toast.makeText(getApplicationContext(), "If you just turned on and off cheats, restart the app.", Toast.LENGTH_SHORT).show();
            }
            else {
            //Button buttonA = R.id.buttonA;
            cheatsActivated = false;}


        if(cheatsActivated){
            replayCounter = 999999;
        }
        else {
            replayCounter = 4;
        }

        String currentPackType = sharedPref.getString(SettingsActivity.PACK_SWITCH, "1");

        if(currentPackType.equals("1")){//Bird sounds
            arrayHolderBoi = birdList;
            arrayNameHolderBoi = bird2List;
        }
        else if(currentPackType.equals("2")){//Random sounds
            arrayHolderBoi = list;
            arrayNameHolderBoi = list2;

        }
        else if(currentPackType.equals("3")){//Musical instrument
            arrayHolderBoi = musicalInstruments;
            arrayNameHolderBoi = musical2Instruments;
        }
        else{
            arrayHolderBoi = list;
            arrayNameHolderBoi = list2;
            System.out.println("You messed up...");
        }
    }




    public static class SettingsFragment extends PreferenceFragmentCompat {



        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);


           /* CheckBoxPreference randomSoundsCheckbox = findPreference("randomSoundsSoundOption");
            CheckBoxPreference birds1SoundCheckbox = findPreference("birds1SoundOption"); */

           /* SwitchPreference switchPreference = findPreference("themeSwitcher");
            ListPreference listPreference = findPreference("packType");
            */





    }
    }


}






