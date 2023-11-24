package com.example.studiowedding.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Task {
    @SerializedName("idHopDong")
    private String id;
    @SerializedName("ngayThucHien")
    private Date dateImplement;
    @SerializedName("trangThaiCongViec")
    private String statusTask;
    @SerializedName("tenDichVu")
    private String nameService;
    @SerializedName("diaDiem")
    private String address;
    @SerializedName("ngayGiatSanPham")
    private Date dataLaundry;
    @SerializedName("ngaySanSang")
    private Date dataReady;
    @SerializedName("hoVaTen")
    private String employee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateImplement() {
        return dateImplement;
    }

    public void setDateImplement(Date dateImplement) {
        this.dateImplement = dateImplement;
    }

    public String getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(String statusTask) {
        this.statusTask = statusTask;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDataLaundry() {
        return dataLaundry;
    }

    public void setDataLaundry(Date dataLaundry) {
        this.dataLaundry = dataLaundry;
    }

    public Date getDataReady() {
        return dataReady;
    }

    public void setDataReady(Date dataReady) {
        this.dataReady = dataReady;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
