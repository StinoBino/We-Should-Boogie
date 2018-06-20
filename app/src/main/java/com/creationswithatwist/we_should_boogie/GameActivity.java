package com.creationswithatwist.we_should_boogie;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class GameActivity extends AppCompatActivity{
    TextView question;
    TextView debug;
    float x1,x2;
    private GestureDetector mDetector;
    FirebaseFirestore db;
    String TAG;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        question = (TextView) findViewById(R.id.question);
        question.setBackgroundColor(Color.parseColor("#22000000"));
        debug = (TextView) findViewById(R.id.debug);
        debug.setBackgroundColor(Color.parseColor("#66000000"));

        //=========================================================================
        db = FirebaseFirestore.getInstance();
        TAG = "Main Activity";

        db.collection("Questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        //=========================================================================


        question.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final float MIN_DISTANCE = 350;

                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        question.performClick();
                        x2 = event.getX();
                        debug.setText("x1: " + x1 + ". x2: " +x2);
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
