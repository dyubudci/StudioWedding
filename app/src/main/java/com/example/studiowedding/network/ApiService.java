package com.example.studiowedding.network;

import com.example.studiowedding.model.Account;
import com.example.studiowedding.network.ManagerUrl;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import com.example.studiowedding.auth.test;
import com.example.studiowedding.view.activity.task.ResponseTask;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    // task
    @GET(ManagerUrl.READ_TASKS)
    Call<ResponseTask> readTask();

    @GET(ManagerUrl.READ_TASKS_ROLE)
    Call<ResponseTask> readTaskByRole(@Query("vaiTro") String role);

    @PUT(ManagerUrl.UPDATE_TASKS)
    Call<ResponseTask> updateTaskById(@Path("id") String id);

    @DELETE(ManagerUrl.DELETE_TASKS)
    Call<ResponseTask> deleteTaskById(@Path("id") String id);
  
  // Account
    @FormUrlEncoded
    @POST(ManagerUrl.ACCOUNT)
    Call<AccountResponse> loginAccount(@Field("idNhanVien") String idNhanVien, @Field("matKhau") String matKhau);  
}
