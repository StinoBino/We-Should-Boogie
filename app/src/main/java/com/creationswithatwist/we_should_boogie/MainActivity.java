package com.creationswithatwist.we_should_boogie;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    Button buttonWard;
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

        buttonWard = new Button(this.getApplicationContext());

        final EditText inputPlayerOne = new EditText(this.getApplicationContext());
        inputPlayerOne.setHint("The name of your date first, you smug.");
        inputPlayerOne.setTextColor(0x917f7);
        linearWrapper.addView(inputPlayerOne);

        final EditText inputPlayerTwo = new EditText(this.getApplicationContext());
        inputPlayerTwo.setHint("Now it's your time to shine!");
        inputPlayerOne.setTextColor(0x917f7);
        linearWrapper.addView(inputPlayerTwo);

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
