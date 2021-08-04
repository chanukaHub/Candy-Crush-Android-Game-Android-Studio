package com.test.candycrush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int[] candies ={
            R.drawable.bluecandy ,
            R.drawable.greencandy ,
            R.drawable.redcandy ,
            R.drawable.orangecandy ,
            R.drawable.yellowcandy ,
            R.drawable.purplecandy ,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}