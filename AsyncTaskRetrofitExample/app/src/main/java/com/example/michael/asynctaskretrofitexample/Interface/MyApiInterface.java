package com.example.michael.asynctaskretrofitexample.Interface;

import com.example.michael.asynctaskretrofitexample.Pojo.Info;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by michael on 10/15/16.
 */
public interface MyApiInterface {
    @GET
    Call<Info> getInfo(@Url String url);
}
