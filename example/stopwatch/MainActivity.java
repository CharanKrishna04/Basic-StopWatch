package com.example.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.time);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
                    public void onChronometerTick(Chronometer chronometerChanged){
                chronometer= chronometerChanged;
            }
        });
    }
    public void startStopChronometer(View view){
        if(start){
            chronometer.stop();
            start=false;
            ((Button)view).setText("Start");
        }
        else
        {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            start=true;
            ((Button)view).setText("Stop");
        }
    }
}
