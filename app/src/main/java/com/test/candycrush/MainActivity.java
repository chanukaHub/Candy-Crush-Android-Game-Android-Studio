package com.test.candycrush;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

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
    ArrayList<ImageView> candy = new ArrayList<>();
    int candyToBeDragged, candyToBeReplaced;

    @SuppressLint("ClickableViewAccessibility")
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
        for (ImageView imageView : candy){
            imageView.setOnTouchListener(new OnSwipeListener(this){
                @Override
                void onSwipeLeft() {
                    super.onSwipeLeft();
                    //Toast.makeText(MainActivity.this,"Left",Toast.LENGTH_SHORT).show();
                    candyToBeDragged = imageView.getId();
                    candyToBeReplaced = candyToBeDragged - 1;
                    candyInterchange();
                }

                @Override
                void onSwipeRight() {
                    super.onSwipeRight();
                    //Toast.makeText(MainActivity.this,"Right",Toast.LENGTH_SHORT).show();
                    candyToBeDragged = imageView.getId();
                    candyToBeReplaced = candyToBeDragged + 1;
                    candyInterchange();
                }

                @Override
                void onSwipeTop() {
                    super.onSwipeTop();
                    //Toast.makeText(MainActivity.this,"Top",Toast.LENGTH_SHORT).show();
                    candyToBeDragged = imageView.getId();
                    candyToBeReplaced = candyToBeDragged - noOfBlocks;
                    candyInterchange();
                }

                @Override
                void onSwipeBottom() {
                    super.onSwipeBottom();
                    //Toast.makeText(MainActivity.this,"Bottom",Toast.LENGTH_SHORT).show();
                    candyToBeDragged = imageView.getId();
                    candyToBeReplaced = candyToBeDragged + noOfBlocks;
                    candyInterchange();
                }
            });
        }
    }

    private void candyInterchange(){
        int background = (int) candy.get(candyToBeReplaced).getTag();
        int background1 = (int) candy.get(candyToBeDragged).getTag();
        candy.get(candyToBeDragged).setImageResource(background);
        candy.get(candyToBeReplaced).setImageResource(background1);
        candy.get(candyToBeDragged).setTag(background);
        candy.get(candyToBeReplaced).setTag(background1);
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
            imageView.setTag(candies[randomCandy]);
            candy.add(imageView);
            gridLayout.addView(imageView);
        }
    }
}