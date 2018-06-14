package com.creationswithatwist.we_should_boogie;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    TextView question;
    TextView debug;
    private GestureDetector mDetector;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        question = (TextView) findViewById(R.id.question);
        question.setBackgroundColor(Color.parseColor("#22000000"));
        debug = (TextView) findViewById(R.id.debug);
        debug.setBackgroundColor(Color.parseColor("#66000000"));


        question.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                final float MIN_DISTANCE = 150;
                float x1 = 0;
                float x2 = 0;
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        if (x2 - x1 > MIN_DISTANCE)
                        {
                            //RIGHT
                            debug.setText("RIGHT");
                        }
                        if (x1 - x2 > MIN_DISTANCE)
                        {
                            //LEFT
                            debug.setText("LEFT");

                        }
                        break;
                }
                return true;
            }
        });


    }

    private String getNewQuestion(){
        String result = "";
        return result;
    }
}
