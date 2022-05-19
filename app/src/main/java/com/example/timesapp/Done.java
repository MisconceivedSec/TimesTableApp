package com.example.timesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Done extends AppCompatActivity {

    public List wrong = new ArrayList();

    public int subjectNum;

    public String mResult;
    public String mTime;
    public String mWrongList;

    public TextView WrongList;
    public TextView wrongCountTV;
    public TextView Time;
    public TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_done);

        mWrongList = getIntent().getStringExtra("WRONG_LIST");

        mResult = getIntent().getStringExtra("RESULT");

        mTime = getIntent().getStringExtra("TIME");

        subjectNum = getIntent().getIntExtra("NUM_CLICKED", 0);

        Log.d("DEBUG", "mResult = " + mResult);

        WrongList = findViewById(R.id.WrongList);

        wrongCountTV = findViewById(R.id.Result);

        Time = findViewById(R.id.Time);

        message = findViewById(R.id.Message);

        Log.d("DEBUG", "wrong count text = " + mResult);

        wrongCountTV.setText(mResult);

        Time.setText(mTime);

        Log.d("DEBUG", "mWrongList = " + mWrongList);

        if ((mWrongList.equals(""))) {

            Log.d("DEBUG", "mWrongList == '' is " + (mWrongList.equals("")));

            message.setVisibility(View.INVISIBLE);

        } else {

            WrongList.setText(mWrongList);

            message.setVisibility(View.VISIBLE);

            message.setText("Practice these numbers in the " + subjectNum + " times table:");

        }


    }
}