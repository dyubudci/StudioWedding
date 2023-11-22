package com.example.studiowedding.view.activity.detail_contract;

public class ServerResponse {
    public static final String RESPONSE_SUCCESS = "success";
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return this.status.equals(RESPONSE_SUCCESS);
    }
}
