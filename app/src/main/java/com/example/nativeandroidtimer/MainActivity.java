package com.example.nativeandroidtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTimerTextView;
    private long mStartedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimerTextView = findViewById(R.id.text_timer);
        mStartedTime = System.currentTimeMillis();

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long timeDifferenceInMillis = System.currentTimeMillis() - mStartedTime;

                double seconds = timeDifferenceInMillis/1000;
                double minutes = seconds/60;
                double leftOverSeconds =  seconds% 60;
                double leftOverMillis = timeDifferenceInMillis %1000 / 10;

                mTimerTextView.setText((int) minutes+ ":" +(int) leftOverSeconds+":"+ (int) leftOverMillis);

                handler.postDelayed(this, 10) ;

            }


        };
        handler.post(runnable);
    }
}