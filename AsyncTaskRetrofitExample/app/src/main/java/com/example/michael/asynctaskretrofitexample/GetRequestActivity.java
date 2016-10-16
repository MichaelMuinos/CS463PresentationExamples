package com.example.michael.asynctaskretrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.michael.asynctaskretrofitexample.Interface.MyApiInterface;
import com.example.michael.asynctaskretrofitexample.Pojo.Info;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetRequestActivity extends AppCompatActivity {

    private final String URL_FOR_DATA = "http://date.jsontest.com";

    private TextView time;
    private TextView epoch;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_request);

        time = (TextView) findViewById(R.id.timeTextView);
        epoch = (TextView) findViewById(R.id.epochTextView);
        date = (TextView) findViewById(R.id.dateTextView);

        performGetRequest();
    }

    private void performGetRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_FOR_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApiInterface myApiInterface = retrofit.create(MyApiInterface.class);

        Call<Info> info = myApiInterface.getInfo(URL_FOR_DATA);
        info.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                time.setText(response.body().getTime());
                epoch.setText(String.valueOf(response.body().getMilliseconds_since_epoch()));
                date.setText(response.body().getDate());
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {
                Log.d("TAG", "You are stupid, it failed.");
            }
        });
    }

}
