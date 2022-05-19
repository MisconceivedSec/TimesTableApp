package com.example.timesapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public int numberClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setButtons();

    }

    public void openTestPage() {
        Intent intent = new Intent(this, Times.class);

        intent.putExtra("NUMBER_CLICKED", numberClicked);

        startActivity(intent);
    }

    public void setButtons() {
        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 2;

                openTestPage();
            }
        });



        Button button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 3;

                openTestPage();
            }
        });


        Button button4 = findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 4;

                openTestPage();
            }
        });


        Button button5 = findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 5;

                openTestPage();
            }
        });


        Button button6 = findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 6;

                openTestPage();
            }
        });


        Button button7 = findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 7;

                openTestPage();
            }
        });


        Button button8 = findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 8;

                openTestPage();
            }
        });


        Button button9 = findViewById(R.id.button9);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 9;

                openTestPage();
            }
        });


        Button button10 = findViewById(R.id.button0);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 10;

                openTestPage();
            }
        });


        Button button11 = findViewById(R.id.button11);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 11;

                openTestPage();
            }
        });


        Button button12 = findViewById(R.id.button12);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 12;

                openTestPage();
            }
        });


        Button button13 = findViewById(R.id.button13);

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberClicked = 13;

                openTestPage();
            }
        });
    }
}