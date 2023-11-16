package com.example.studiowedding.model;

import android.widget.ImageView;

public class ListclientModel {
    private String name;
    private String phone;
    private String address;
    private ImageView imgUpdateClient;

    public ListclientModel(ImageView imgUpdateClient) {
        this.imgUpdateClient = imgUpdateClient;
    }

    public ListclientModel(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public ImageView getImgUpdateClient() {
        return imgUpdateClient;
    }

    public void setImgUpdateClient(ImageView imgUpdateClient) {
        this.imgUpdateClient = imgUpdateClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
