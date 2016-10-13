package com.example.michael.cs463_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityOne extends AppCompatActivity {

    private final String TAG = "CYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_one);
        Log.d(TAG, "Activity One: onCreate");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityOne.this, ActivityTwo.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activity One: onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity One: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity One: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity One: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity One: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity One: onDestroy");
    }

}
