package com.test.candycrush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] candies ={
            R.drawable.bluecandy ,
            R.drawable.greencandy ,
            R.drawable.redcandy ,
            R.drawable.orangecandy ,
            R.drawable.yellowcandy ,
            R.drawable.purplecandy
    };

    int widthOfBlock, noOfBlocks =8, widthOfScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        widthOfScreen=displayMetrics.widthPixels;
        int heightOfScreen =displayMetrics.heightPixels;
        widthOfBlock= widthOfScreen/noOfBlocks;
        createBoard();
    }

    private void createBoard() {
        GridLayout gridLayout = findViewById(R.id.board);
        gridLayout.setRowCount(noOfBlocks);
        gridLayout.setColumnCount(noOfBlocks);

        //we want square
        gridLayout.getLayoutParams().width = widthOfScreen;
        gridLayout.getLayoutParams().height = widthOfScreen;

        for (int i =0; i < noOfBlocks * noOfBlocks; i++){
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(widthOfBlock,widthOfBlock));
            imageView.setMaxHeight(widthOfBlock);
            imageView.setMaxWidth(widthOfBlock);
            int randomCandy= (int) Math.floor(Math.random() * candies.length);
            imageView.setImageResource(candies[randomCandy]);
            gridLayout.addView(imageView);
        }
    }
}