package com.example.studiowedding.network;

import com.example.studiowedding.model.test;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/abc")
    Call<test> TEST_CALL();
}
