package com.example.michael.asynctaskexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncTaskActivity extends AppCompatActivity {
    private final String URL_FOR_DATA = "http://date.jsontest.com";

    private TextView time;
    private TextView epoch;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        time = (TextView) findViewById(R.id.timeTextView);
        epoch = (TextView) findViewById(R.id.epochTextView);
        date = (TextView) findViewById(R.id.dateTextView);

        new GetTimeInfo().execute();
    }

    // 1 param: doinback
    // 2 param: preexec
    // 3 param: postexec
    private class GetTimeInfo extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();

            try {
                URL url = new URL(URL_FOR_DATA);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(isr);

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }

            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject mainObject = new JSONObject(result);
                time.setText(mainObject.getString("time"));
                epoch.setText(mainObject.getString("milliseconds_since_epoch"));
                date.setText(mainObject.getString("date"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
