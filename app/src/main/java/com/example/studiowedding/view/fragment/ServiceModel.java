package com.example.studiowedding.view.fragment;

public class ServiceModel {
        private String tenvaycuoi;
        private int giatien;
        private String trangthai;

    public String getTenvaycuoi() {
        return tenvaycuoi;
    }

    public void setTenvaycuoi(String tenvaycuoi) {
        this.tenvaycuoi = tenvaycuoi;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public ServiceModel(String tenvaycuoi, String giatien, String trangthai) {
            this.tenvaycuoi = tenvaycuoi;
            this.giatien = Integer.parseInt(giatien);
            this.trangthai = trangthai;
        }


        // Bạn có thể thêm các phương thức getter và setter khác tùy theo nhu cầu của bạn


}
