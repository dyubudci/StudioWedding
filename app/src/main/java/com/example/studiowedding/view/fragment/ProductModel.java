package com.example.studiowedding.view.fragment;

public class ProductModel {
        private String chupanhcuoi;
        private int giavay;


    public String getChupanhcuoi() {
        return chupanhcuoi;
    }

    public void setChupanhcuoi(String chupanhcuoi) {
        this.chupanhcuoi = chupanhcuoi;
    }

    public int getgiavay() {
        return giavay;
    }

    public void setgiavay(int giavay) {
        this.giavay = giavay;
    }





    public ProductModel(String chupanhcuoi, String giavay) {
            this.chupanhcuoi = chupanhcuoi;
            this.giavay = Integer.parseInt(giavay);

        }


        // Bạn có thể thêm các phương thức getter và setter khác tùy theo nhu cầu của bạn


}
