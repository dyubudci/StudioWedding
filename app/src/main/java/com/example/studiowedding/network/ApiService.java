package com.example.studiowedding.network;

import com.example.studiowedding.auth.test;
import com.example.studiowedding.model.ContractDetail;
import com.example.studiowedding.view.activity.detail_contract.ServerResponse;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/abc")
    Call<test> TEST_CALL();

    @GET(ManagerUrl.CONTRACT_DETAILS_URL)
    Call<List<ContractDetail>> getContractDetails();

    @FormUrlEncoded
    @POST(ManagerUrl.INSERT_CONTRACT_DETAIL)
    Call<ServerResponse> insertContractDetailWithProduct(
            @Field("contractDetailID") String contractDetailID,
            @Field("dateOfHire") String dateOfHire,
            @Field("dateOfReturn") String dateOfReturn,
            @Field("productID") int productID
    );
}
