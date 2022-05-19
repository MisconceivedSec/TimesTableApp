package com.explorer.timestable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Animation plus1, plus2, minus1, minus2;

    boolean aniRunning;

    int selectedNum;

    TextView selectedNumTv;

    ImageButton mPlus;
    ImageButton mMinus;
    ImageButton mPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aniRunning = false;
        selectedNumTv = findViewById(R.id.curNum);
        mPlus = findViewById(R.id.plus);
        mMinus = findViewById(R.id.minus);
        mPlay = findViewById(R.id.play);

        selectedNumTv.setText("2");
        selectedNum = Integer.parseInt(selectedNumTv.getText().toString());

        plus1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.plus1);
        plus2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.plus2);
        minus1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.minus1);
        minus2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.minus2);
        buttons();



        setButtons();

    }

    public void openTestPage() {
        Intent intent = new Intent(this, Times.class);

        intent.putExtra("SELECTED_NUM", selectedNum);

        startActivity(intent);
    }

    public void buttons() {

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openTestPage();

            }
        });

        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedNum != 13 && !aniRunning) {

                    aniRunning = true;

                    selectedNum++;

                    selectedNumTv.startAnimation(plus1);

                    final Handler handler = new Handler();

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            selectedNumTv.setText(String.valueOf(selectedNum));

                        }
                    }, 250);

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            selectedNumTv.startAnimation(plus2);

                        }
                    }, 250);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            aniRunning = false;
                        }
                    }, 250);
                }
            }
        });

        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedNum != 2 && !aniRunning) {

                    aniRunning = true;

                    selectedNum--;

                    selectedNumTv.startAnimation(minus1);

                    final Handler handler = new Handler();

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            selectedNumTv.setText(String.valueOf(selectedNum));

                        }
                    }, 250);

                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            selectedNumTv.startAnimation(minus2);

                        }
                    }, 250);


                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            aniRunning = false;
                        }
                    }, 250);

                }
            }
        });


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

        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        button7.setVisibility(View.GONE);
        button8.setVisibility(View.GONE);
        button9.setVisibility(View.GONE);
        button10.setVisibility(View.GONE);
        button11.setVisibility(View.GONE);
        button12.setVisibility(View.GONE);
        button13.setVisibility(View.GONE);
    }
}