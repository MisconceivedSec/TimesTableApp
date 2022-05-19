package com.explorer.timestable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int selectedNum;

    boolean mCDtimer;

    ImageView mType;

    Drawable CDtimer, SWtimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SWtimer = getResources().getDrawable(R.drawable.timer);

        CDtimer = getResources().getDrawable(R.drawable.ic_sand_timer);

        mType = findViewById(R.id.type);

        mCDtimer = getIntent().getBooleanExtra("TYPE", Boolean.parseBoolean("0"));

        if (mCDtimer) {

            mType.setImageDrawable(CDtimer);

        } else {

            mType.setImageDrawable(SWtimer);

        }

        setButtons();

    }

    public void openTestPage() {
        Intent intent = new Intent(this, Times.class);

        intent.putExtra("SELECTED_NUM", selectedNum);
        intent.putExtra("CD_TIMER", mCDtimer);

        startActivity(intent);
    }


    public void setButtons() {
        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 2;

                openTestPage();
            }
        });



        Button button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 3;

                openTestPage();
            }
        });


        Button button4 = findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 4;

                openTestPage();
            }
        });


        Button button5 = findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 5;

                openTestPage();
            }
        });


        Button button6 = findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 6;

                openTestPage();
            }
        });


        Button button7 = findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 7;

                openTestPage();
            }
        });


        Button button8 = findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 8;

                openTestPage();
            }
        });


        Button button9 = findViewById(R.id.button9);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 9;

                openTestPage();
            }
        });


        Button button10 = findViewById(R.id.button0);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 10;

                openTestPage();
            }
        });


        Button button11 = findViewById(R.id.button11);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 11;

                openTestPage();
            }
        });


        Button button12 = findViewById(R.id.button12);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 12;

                openTestPage();
            }
        });


        Button button13 = findViewById(R.id.button13);

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedNum = 13;

                openTestPage();
            }
        });
    }
}