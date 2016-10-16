package com.example.michael.icepickexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import icepick.Icepick;
import icepick.State;

public class MainActivity extends AppCompatActivity {

    private TextView clickTextView;
    private ImageButton button;

    @State
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Needed to restore our variable
        Icepick.restoreInstanceState(this, savedInstanceState);

        clickTextView = (TextView) findViewById(R.id.clickTextview);
        clickTextView.setText(String.valueOf(count));

        button = (ImageButton) findViewById(R.id.buttonImage);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setImageResource(R.drawable.buttonred);
                    clickTextView.setText(String.valueOf(++count));
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    button.setImageResource(R.drawable.buttongreen);
                }
                return false;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Saves all variables with the state annotation
        Icepick.saveInstanceState(this, outState);
    }
}
