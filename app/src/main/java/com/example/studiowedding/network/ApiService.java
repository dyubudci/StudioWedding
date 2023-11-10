package com.example.studiowedding.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ApiService {
    ApiService API_SERVICE = new Retrofit.Builder()
            .baseUrl(ManagerUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
}
