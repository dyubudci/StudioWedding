package com.example.studiowedding.network;

import com.example.studiowedding.model.Account;
import com.example.studiowedding.network.ManagerUrl;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST(ManagerUrl.ACCOUNT)
    Call<AccountResponse> loginAccount(@Field("idNhanVien") String idNhanVien, @Field("matKhau") String matKhau);
}
