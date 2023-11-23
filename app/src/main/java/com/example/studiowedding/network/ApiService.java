package com.example.studiowedding.network;

import com.example.studiowedding.auth.test;
import com.example.studiowedding.model.Contract;
import com.example.studiowedding.model.ContractDetail;
import com.example.studiowedding.model.Customer;
import com.example.studiowedding.model.Incurrent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/abc")
    Call<test> TEST_CALL();

    @GET(ManagerUrl.CONTRACT_DETAILS_URL)
    Call<List<ContractDetail>> getContractDetails();


    // CONTRACT
    @GET(ManagerUrl.CONTRACTS)
    Call<List<Contract>>getContracts();
    @GET(ManagerUrl.CONTRACT_CLIENTS)
    Call<List<Customer>>getCustomers();
    @GET(ManagerUrl.CONTRACT_DETAIL_CONTRACT)
    Call<List<ContractDetail>>getAllDetailContractByIdHDTT(@Path("idHDTamThoi") String idHDTamThoi);
    @GET(ManagerUrl.CONTRACTS_ID)
    Call<Contract> getContractById(@Path("idHopDong") String idHopDong);

    @GET(ManagerUrl.CONTRACTS_PAYMENT)
    Call<List<Contract>> getContractsByPayment();

    @GET(ManagerUrl.CONTRACTS_PROGESS)
    Call<List<Contract>> getContractsByProgess();

    @GET(ManagerUrl.CONTRACTS_INCURRENT)
    Call<List<Contract>> getContractsByIncurrent();

    @GET(ManagerUrl.INCURRENT)
    Call<List<Incurrent>> getIncurrent();

    @POST(ManagerUrl.ADD_CONTRACT)
    Call<Void> insertContract(@Body Contract newContract);

    @POST(ManagerUrl.INCURRENT_ADD)
    Call<Void> insertIncurrent(@Body Incurrent newIncurrent);

    @PUT(ManagerUrl.CONTRACT_UPDATE)
    Call<Void> updateContract(@Path("idHopDong") String idHopDong, @Body Contract updatedContract);

    @PUT(ManagerUrl.CONTRACT_DELETE)
    Call<Void> deleteContract(@Path("idHopDong") String idHopDong);

    @PUT(ManagerUrl.INCURRENT_DELETE)
    Call<Void> deleteIncurrent(@Path("idPhatSinh") String idPhatSinh);


}
