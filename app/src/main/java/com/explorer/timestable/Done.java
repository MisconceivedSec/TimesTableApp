package com.explorer.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Done extends AppCompatActivity {

    public boolean won, CDTimer;

    public List wrong = new ArrayList();

    public int subjectNum;

    public int mResult;
    public String mTime;
    public String mWrongList;

    public TextView WrongList, score, Time, message, result_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_done);

        CDTimer = getIntent().getBooleanExtra("CD_TIMER", Boolean.parseBoolean("0"));

        won = getIntent().getBooleanExtra("WON", Boolean.parseBoolean("0"));

        mWrongList = getIntent().getStringExtra("WRONG_LIST");

        mResult = getIntent().getIntExtra("RESULT", 0);

        mTime = getIntent().getStringExtra("TIME");

        subjectNum = getIntent().getIntExtra("NUM_CLICKED", 0);

        Log.d("DEBUG", "mResult = " + mResult);

        result_time = findViewById(R.id.Result_Time);

        WrongList = findViewById(R.id.WrongList);

        score = findViewById(R.id.score);

        Time = findViewById(R.id.Time);

        message = findViewById(R.id.Message);

        Log.d("DEBUG", "wrong count text = " + mResult);

        Log.d("DEBUG", "mWrongList = " + mWrongList);

        if (CDTimer) CD();
        else SW();

        if ((mWrongList.equals(""))) {

            Log.d("DEBUG", "mWrongList == '' is true");

            WrongList.setVisibility(View.GONE);

            message.setVisibility(View.GONE);

        } else if (mWrongList.length() > 1) {

            WrongList.setVisibility(View.VISIBLE);

            message.setVisibility(View.VISIBLE);

            WrongList.setText(mWrongList);

            message.setText("The numbers to practice:");

        } else {
            WrongList.setVisibility(View.VISIBLE);

            message.setVisibility(View.VISIBLE);

            WrongList.setText(mWrongList);

            message.setText("The number to practice:");
        }
    }

    public void CD() {

        score.setText(mResult + "%");

        Time.setText("Remaining time: " + mTime);

        if (won && mResult >= 90) {
            result_time.setText("Superb!");
        } else if (won && mResult < 90 && mResult >= 60) {
            result_time.setText("Not bad :)");
        } else if (won && mResult < 60 && mResult >= 40) {
            result_time.setText("Maybe some more practice?");
        } else if (won && mResult < 40) {
            result_time.setText("Try again :(");
        } else result_time.setText("Work on your speed!");


    }

    public void SW() {

        score.setText(mResult + "%");

        Time.setText("Your time: " + mTime);

        if (mResult >= 90) {
            result_time.setText("Superb!");
        } else if (mResult < 90 && mResult >= 60) {
            result_time.setText("Not bad :)");
        } else if (mResult < 60 && mResult >= 40) {
            result_time.setText("Maybe some more practice?");
        } else if (mResult < 40) {
            result_time.setText("Try again :(");
        }

    }
}