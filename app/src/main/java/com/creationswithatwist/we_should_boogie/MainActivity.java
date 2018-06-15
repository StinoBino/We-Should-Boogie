package com.creationswithatwist.we_should_boogie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearWrapper;
    int adjactivePlayerOne;
    int adjactivePlayerTwo;
    AlertDialog.Builder alertDialog;
    Color color;
    Button buttonWard;
    FirebaseFirestore db;
    String TAG;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearWrapper = (LinearLayout) findViewById(R.id.linear_wrapper);

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
        Random rand = new Random();
        adjactivePlayerOne = rand.nextInt(4);
        adjactivePlayerTwo = rand.nextInt(4);
        while (adjactivePlayerOne == adjactivePlayerTwo) {
            adjactivePlayerTwo = rand.nextInt(4);
        }

        buttonWard = new Button(this.getApplicationContext());

        final EditText inputPlayerOne = new EditText(this.getApplicationContext());
        inputPlayerOne.setTextColor(color.parseColor("#595959"));
        inputPlayerOne.setHint("The name of your date first, you smug.");
        inputPlayerOne.setHintTextColor(color.parseColor("#8c8c8c"));
        linearWrapper.addView(inputPlayerOne);

        final EditText inputPlayerTwo = new EditText(this.getApplicationContext());
        inputPlayerTwo.setTextColor(color.parseColor("#595959"));
        inputPlayerTwo.setHint("Now it's your time to shine!");
        inputPlayerTwo.setHintTextColor(color.parseColor("#8c8c8c"));
        linearWrapper.addView(inputPlayerTwo);

        Button button = new Button(this.getApplicationContext());
        button.setText("Let's Boogie");
        linearWrapper.addView(button);

        alertDialog = new AlertDialog.Builder(this);

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {

                        if(inputPlayerOne.getText().toString().equals("")){
                            alertDialog.setMessage("Insert the name of your date you dummy");
                            alertDialog.show();
                            return;
                        } else {
                            Player player1 = new Player(inputPlayerOne.getText().toString(), adjactivePlayerOne);
                            alertDialog.setMessage(player1.name);
                            alertDialog.show();
                        }

                        if(inputPlayerTwo.getText().toString().equals("")) {
                            alertDialog.setMessage("You forgot your own name... Nerves, am I right?");
                            alertDialog.show();
                            return;
                        } else {
                            Player player2 = new Player(inputPlayerTwo.getText().toString(), adjactivePlayerTwo);
                            alertDialog.setMessage(player2.name);
                            alertDialog.show();
                        }
                    }
                });
        buttonWard.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent intent = new Intent(getBaseContext(), GameActivity.class);
                        startActivity(intent);
                    }
                });
        linearWrapper.addView(buttonWard);

    }
}
