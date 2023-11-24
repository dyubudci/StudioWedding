package com.example.studiowedding.network;

import com.example.studiowedding.view.activity.task.ResponseTask;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    @FormUrlEncoded
    Call<ResponseTask> updateTaskById(@Path("id") int id,
                                      @Field("statusTask") String statusTask);

    @DELETE(ManagerUrl.DELETE_TASKS)
    Call<ResponseTask> deleteTaskById(@Path("id") int id);
}
