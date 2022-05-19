package com.explorer.timestable;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


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
    public String wrong_list_string;

    public boolean firstWrong;
    public boolean canType;
    public boolean incorrect;
    public boolean mCDtimer;
    public boolean isResume;
    public boolean won;

    public Handler mHandler;

    public long tMilliSec, tStart, tBuff, tUpdate = 0L;

    public int shortest_seconds_stopwatch;

    public static long START_TIME_IN_MILLIS;

    public CountDownTimer CDTimer;

    public boolean TimerRunning;

    public long mTimeLeft;

    public float wrongCount;
    public int totalTime;

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
    public int result;

    //---VIEWS---//

    Chronometer timer;

    CountDownTimer cTimer = null;

    TextView Input;
    TextView OutputQuestion;
    TextView feedback;
    TextView CDView;

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

    public Drawable SWtimer, CDtimer;
    ImageView mType;


    //---FUNCTIONS---//

    public void runSTPW() {

        if (!isResume) {

            tStart = SystemClock.uptimeMillis();

            mHandler.postDelayed(runnable, 0);

            timer.start();

            isResume = true;

        }
    }

    public void pauseSTPW() {

        if (isResume) {

            tBuff += tMilliSec;

            mHandler.removeCallbacks(runnable);

            timer.stop();

            isResume = false;

        }

    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {

            tMilliSec = SystemClock.uptimeMillis() - tStart;

            tUpdate = tBuff + tMilliSec;

            sec = (int) ( tUpdate / 1000 );

            min = sec / 60;

            sec = sec % 60;

            milliSec = (int) ( tUpdate / 10 );

            timer.setText(String.format("%02d", min) + ":" + String.format("%02d", sec));

            mHandler.postDelayed(this, 60);

        }
    };

    public void runTimer() {
        if (TimerRunning) {
            pauseTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        CDTimer = new CountDownTimer(mTimeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                if (!won) {
                    TimerRunning = false;
                    won = false;
                    Next();
                }
            }
        }.start();

        TimerRunning = true;
    }

    public void updateCountdownText() {
        int minutes = (int) (mTimeLeft / 1000) / 60;
        int seconds = (int) (mTimeLeft / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        CDView.setText(timeLeftFormatted);

    }

    public void pauseTimer() {

        CDTimer.cancel();
        TimerRunning = false;

    }

    public void StartUp() {
        SWtimer = getResources().getDrawable(R.drawable.timer);

        CDtimer = getResources().getDrawable(R.drawable.ic_sand_timer);

        mType = findViewById(R.id.type);

        mCDtimer = getIntent().getBooleanExtra("CD_TIMER", Boolean.parseBoolean("0"));

        if (mCDtimer) {

            mType.setImageDrawable(CDtimer);

        } else {

            mType.setImageDrawable(SWtimer);

        }


        START_TIME_IN_MILLIS = 60000 + 1000;
        mTimeLeft = START_TIME_IN_MILLIS;

        mHandler = new Handler();

        result = 0;

        canType = true;

        firstWrong = false;

        wrongCount = 0;

        rightCount = 0;

        i = 0;

        feedback.setText("");

        Selected.clear();

        SubjectNumber = getIntent().getIntExtra("SELECTED_NUM", 0);

        Log.v("Debug", "You chose the number " + SubjectNumber);

        if (mCDtimer) {

            CDView.setVisibility(View.VISIBLE);
            timer.setVisibility(View.GONE);

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    runTimer();

                }
            }, aniTrans);

        } else {

            timer.setVisibility(View.VISIBLE);
            CDView.setVisibility(View.GONE);

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    runSTPW();

                }
            }, aniTrans);

        }
    }

    public void SetViews() {

        CDView = findViewById(R.id.CDTimer);

        timer = findViewById(R.id.SWtimer);

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

            if (!incorrect) {rightCount++;}

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

                        if (mCDtimer && mTimeLeft > 0) {

                            won = true;

                        }

                        Next();

                    } else MainLoop();

                    canType = true;

                }
            }, 1000);


        }
    }

    public void Next() {

        Log.d("DEBUG", "Selected.size() = " + Selected.size());
        Log.d("DEBUG", "Nexting");

        totalTime = (min * 60) + sec;

        Log.d("DEBUG", "total time: " + totalTime);

        if(!mCDtimer) {
            shortest_seconds_stopwatch = PrefConfig.retrieve_high_score(getApplicationContext());
            if (shortest_seconds_stopwatch < totalTime) {
                shortest_seconds_stopwatch = totalTime;
                PrefConfig.store_high_score(getApplicationContext(), shortest_seconds_stopwatch);
            }
        }

        if (!wrong.isEmpty()) {

            Collections.sort(wrong);

            wrong_list_string = "";

            if (!(wrong.size() == 1)) {

                wrong_list_string = wrong_list_string + wrong.get(0);

                for (int i = 1; i <= wrong.size() - 1; i++) {

                    if (i != wrong.size() - 1) {
                        wrong_list_string = wrong_list_string + ", " + wrong.get(i);
                    } else {
                        wrong_list_string = wrong_list_string + " and " + wrong.get(i);
                    }
                }
            } else wrong_list_string = wrong.get(0).toString();

        } else wrong_list_string = "";

        Log.d("Debug", "wrongList = " + wrong_list_string);

        wrongCount = 12 - rightCount;

        result = Math.round(100 - ((wrongCount / 12) * 100));

        Log.d("DEBUG", "Math = " + (wrongCount / 12));

        Log.d("DEBUG", "Wrong count = " + wrongCount);

        Log.d("DEBUG", "Right count = " + rightCount);

        Log.d("DEBUG", "Result = " + result);

        Intent intent = new Intent(this, Done.class);

        intent.putExtra("SHORTEST_TIME", shortest_seconds_stopwatch);

        intent.putExtra("WRONG_LIST", wrong_list_string);

        intent.putExtra("TIME", time);

        intent.putExtra("RESULT", result);

        intent.putExtra("NUM_CLICKED", SubjectNumber);

        intent.putExtra("CD_TIMER", mCDtimer);

        if (mCDtimer) {
            intent.putExtra("WON", won);
            time = CDView.getText().toString();

        } else time = timer.getText().toString();

        intent.putExtra("TIME", time);

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
            public void onClick(View v) { Next(); }});

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