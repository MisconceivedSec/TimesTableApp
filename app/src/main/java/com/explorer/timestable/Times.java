package com.explorer.timestable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Times extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times);

        SetViews();

        StartUp();

        setButtons();

        MainLoop();

    }


    //---VARIABLES---//

    public List Selected = new ArrayList();
    public List wrong = new ArrayList();

    public String newText;
    public String time;
    public String wrongList;

    public boolean firstWrong;
    public boolean canType;
    public boolean incorrect;

    public boolean isResume;

    public Handler mHandler;

    public long tMilliSec, tStart, tBuff, tUpdate = 0L;
    public long pauseOffset;

    public float wrongCount;
    public float totalTime;

    public int sec, min, milliSec;
    public int i;
    public int aniTrans;
    public int rightCount;
    public int SubjectNumber;
    public int RanInt;
    public int Multiplier;
    public int cran;
    public int UsAnswer;

    public String Question;
    public String result;

    //---VIEWS---//

    Chronometer timer;

    TextView Input;
    TextView OutputQuestion;
    TextView feedback;

    Button clear;
    Button done;
    Button but0;
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;
    Button but7;
    Button but8;
    Button but9;
    Button del;
    Button next;



    //---FUNCTIONS---//

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {

            tMilliSec = SystemClock.uptimeMillis() - tStart;

            tUpdate = tBuff + tMilliSec;

            sec = (int) ( tUpdate / 1000 );

            min = sec / 60;

            sec = sec % 60;

            milliSec = (int) ( tUpdate % 100 );

            timer.setText(String.format("%02d", min) + ":"
                    + String.format("%02d", sec));
//                    + ":" + String.format("%02d", milliSec)

            mHandler.postDelayed(this, 60);

        }
    };

    public void plTimer() {

        tStart = SystemClock.uptimeMillis();

        mHandler.postDelayed(runnable, 0);

        timer.start();

    }


    public void StartUp() {

        mHandler = new Handler();

        result = "";

        canType = true;

        firstWrong = false;

        wrongCount = 0;

        rightCount = 0;

        i = 0;

        feedback.setText("");

        Selected.clear();

        SubjectNumber = getIntent().getIntExtra("SELECTED_NUM", 0);

        Log.v("Debug", "You chose the number " + SubjectNumber);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                plTimer();

            }
        }, aniTrans);

    }


    public void SetViews() {

        timer = findViewById(R.id.timer);

        OutputQuestion = findViewById(R.id.OutputQuest);

        feedback = findViewById(R.id.feedback);

        Input = findViewById(R.id.Input);

        done = findViewById(R.id.done);

        clear = findViewById(R.id.clear);

        del = findViewById(R.id.delete);

        but0 = findViewById(R.id.button0);

        but1 = findViewById(R.id.button1);

        but2 = findViewById(R.id.button2);

        but3 = findViewById(R.id.button3);

        but4 = findViewById(R.id.button4);

        but5 = findViewById(R.id.button5);

        but6 = findViewById(R.id.button6);

        but7 = findViewById(R.id.button7);

        but8 = findViewById(R.id.button8);

        but9 = findViewById(R.id.button9);

        next = findViewById(R.id.Next);

    }


    public void MoveOn() {

        canType = false;

        UsAnswer = Integer.parseInt(Input.getText().toString());

        if (UsAnswer != cran) {

            incorrect = true;

            if (!wrong.contains(RanInt)) {

                wrong.add(RanInt);

            }

            feedback.setTextColor(Color.RED);

            feedback.setText("✖");

            Log.d("Debug", "Wrong");



            //---WAIT---//


            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {

                @Override
                public void run() {

                    feedback.setText("");

                    canType = true;

                }
            }, 1000);


            Input.setText("");

        } else {

            if (!incorrect) { rightCount++; }

            i++;

            Log.v("Debug", "This is count number: " + i);

            feedback.setTextColor(Color.GREEN);

            Input.setText("");

            feedback.setText("✔");


            //---WAIT---//

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {

                @Override

                public void run() {

                    feedback.setText("");

                    if (Selected.size() == 12) {

                        Next();

                    } else MainLoop();

                    canType = true;

                }
            }, 1000);


        }
    }

        public void Next() {

            totalTime = min + (milliSec / 60);

            if (!wrong.isEmpty()) {

                Collections.sort(wrong);

                wrongList = wrong.toString();

                wrongList = wrongList.replaceAll("\\]", "").replaceAll("\\[", "");

            } else wrongList = "";

            Log.d("Debug", "wrongList = " + wrongList);

            time = timer.getText().toString();

            wrongCount = 12 - rightCount;

            result = String.valueOf(Math.round(100 - ((wrongCount / 12) * 100))) + "%";

            Log.d("DEBUG", "Math = " + (wrongCount / 12));

            Log.d("DEBUG", "Wrong count = " + wrongCount);

            Log.d("DEBUG", "Right count = " + rightCount);

            Log.d("DEBUG", "Result = " + result);

            Intent intent = new Intent(this, Done.class);

            intent.putExtra("WRONG_LIST", wrongList);

            intent.putExtra("TIME", time);

            intent.putExtra("RESULT", result);

            intent.putExtra("NUM_CLICKED", SubjectNumber);

            Log.d("Debug", "Starting new activity");

            startActivity(intent);
        }

        public void MainLoop() {

            incorrect = false;

            Input.setText("");

            RanInt = (int) (Math.random() * (13 - 2 + 1) + 2);

            while (Selected.contains(RanInt)) {

                RanInt = (int) (Math.random() * (13 - 2 + 1) + 2);

            }

            Log.v("Debug", "RanInt = " + RanInt);

            Selected.add(RanInt);

            Multiplier = RanInt;

            cran = SubjectNumber * Multiplier;

            Log.v("Debug", "cran = " + cran);

            Question = " " + SubjectNumber + " × " + Multiplier + " = ";

            OutputQuestion.setText(Question);

   }

        public void setButtons () {

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { Next(); }
            });

            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (Input != null && Input.length() > 0 ) {

                        MoveOn();

                    }
                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Input != null && Input.length() > 0) {
                        Input.setText("");
                    }
                }
            });

            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    newText = Input.getText().toString();

                    Log.v("Debug", "newText before = " + newText);

                    if (newText != null && newText.length() > 0) {

                        newText = newText.substring(0, newText.length() - 1);

                    }

                    Log.v("Debug", "newText after = " + newText);

                    Input.setText(newText);
                }
            });

            
            but0.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {

                        if (canType) {Input.append("0");}

                }
            });

            
            but1.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("1");}

                }
            });

            
            but2.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {

                    if (canType) {Input.append("2");}

                }
            });

            
            but3.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("3");}

                }
            });

            
            but4.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("4");}

                }
            });

            
            but5.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("5");}

                }
            });

            
            but6.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("6");}

                }
            });

            
            but7.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("7");}

                }
            });

            
            but8.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("8");}

                }
            });

            
            but9.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View view) {
                                        
                    if (canType) {Input.append("9");}

                }
            });
        }
}