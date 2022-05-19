package com.explorer.timestable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    ImageButton timer, CDtimer;

    public boolean mCDtimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        timer = findViewById(R.id.SWtimer);
        CDtimer = findViewById(R.id.countdown_timer);

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCDtimer = false;

                openMain();

            }
        });

        CDtimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCDtimer = true;

                openMain();

            }
        });
    }

    public void openMain() {

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("TYPE", mCDtimer);

        startActivity(intent);

    }

}

