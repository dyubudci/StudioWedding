package com.example.studiowedding.view.activity.detail_contract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.studiowedding.R;

public class ProductSelectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_select);

        initView();
        initToolbar();
        setListeners();
    }

    private void initView() {

    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setListeners() {
        toolbar.setNavigationOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());
    }
}