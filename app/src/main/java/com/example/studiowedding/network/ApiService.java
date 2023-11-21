package com.example.studiowedding.network;

import com.example.studiowedding.auth.test;
import com.example.studiowedding.model.ContractDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/abc")
    Call<test> TEST_CALL();

    @GET(ManagerUrl.CONTRACT_DETAILS_URL)
    Call<List<ContractDetail>> getContractDetails();
}
