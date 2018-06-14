package com.creationswithatwist.we_should_boogie;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearWrapper;
    int adjactivePlayerOne;
    int adjactivePlayerTwo;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearWrapper = (LinearLayout) findViewById(R.id.linear_wrapper);

        Random rand = new Random();
        adjactivePlayerOne = rand.nextInt(4);
        adjactivePlayerTwo = rand.nextInt(4);
        while (adjactivePlayerOne == adjactivePlayerTwo) {
            adjactivePlayerTwo = rand.nextInt(4);
        }

        final EditText inputPlayerOne = new EditText(this.getApplicationContext());
        final EditText inputPlayerTwo = new EditText(this.getApplicationContext());
        Button button = new Button(this.getApplicationContext());
        button.setText("Let's Boogie");
        linearWrapper.addView(button);

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Player player1 = new Player(inputPlayerOne.getText().toString(), adjactivePlayerOne);
                        Player player2 = new Player(inputPlayerTwo.getText().toString(), adjactivePlayerTwo);
                    }
                });
    }
}
