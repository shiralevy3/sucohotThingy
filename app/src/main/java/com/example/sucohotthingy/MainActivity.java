package com.example.sucohotthingy;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText inputEditText;
    private String[] responses = {
            "Great choice!", "That's interesting!", "You are amazing!",
            "Keep going!", "Sounds awesome!", "Fantastic!",
            "Impressive!", "Way to go!", "Nice idea!", "Wonderful thought!"
    };
    private int currentColorIndex = 0;
    private int[] colors = {Color.BLACK, Color.RED, Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button showTextButton = findViewById(R.id.showTextButton);
        Button changeColorButton = findViewById(R.id.changeColorButton);

        // מאזין לכפתור "Show me the text"
        showTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = inputEditText.getText().toString();
                Random random = new Random();
                int randomIndex = random.nextInt(responses.length);
                String response = responses[randomIndex];
                resultTextView.setText(response + " " + userInput);
            }
        });

        // מאזין לכפתור "Change color"
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentColorIndex = (currentColorIndex + 1) % colors.length;
                resultTextView.setTextColor(colors[currentColorIndex]);
            }
        });
    }
}
