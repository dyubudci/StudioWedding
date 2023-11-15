package com.example.studiowedding.view.activity.contract;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.studiowedding.R;

public class AddContractActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edPaymentStatus,edPickClient;
    private ImageView imgBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contract);

        imgBack=findViewById(R.id.imgBackFromAddContract);
        edPaymentStatus=findViewById(R.id.edPaymentStatus);
        edPickClient=findViewById(R.id.edAddClientContract);


        imgBack.setOnClickListener(this);
        edPaymentStatus.setOnClickListener(this);
        edPickClient.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBackFromAddContract:
                finish();
                break;
            case R.id.edPaymentStatus:
                showPopupMenu(view);
                break;
            case R.id.edAddClientContract:
                startActivity(new Intent(this,PickClientActivity.class));
                break;
        }
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu_payment_status_contract, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_paid:
                        edPaymentStatus.setText("Đã thanh toán");
                        return true;
                    case R.id.action_unpaid:
                        edPaymentStatus.setText("Chưa thanh toán");
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
}