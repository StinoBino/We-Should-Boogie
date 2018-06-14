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
    private GestureDetector mDetector;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        question = (TextView) findViewById(R.id.question);
        question.setBackgroundColor(Color.parseColor("#22000000"));


        question.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Log.e("ward","test");
                return true;
            }

        });


    }

    private String getNewQuestion(){
        String result = "";
        return result;
    }
}
