package com.example.studiowedding.view.activity.detail_contract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.studiowedding.R;
import com.example.studiowedding.adapter.ProductSelectAdapter;
import com.example.studiowedding.model.Product;
import com.example.studiowedding.model.Service;
import com.example.studiowedding.network.ApiClient;
import com.example.studiowedding.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductSelectActivity extends AppCompatActivity implements ProductSelectAdapter.ItemListener {
    public static final String TAG = "ProductSelectActivity";
    public static final String PRODUCT_SELECTED_EXTRA = "ProductSelected";
    private ImageView backImageView;
    private RecyclerView productSelectRecyclerView;
    private ProductSelectAdapter productSelectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_select);

        initView();
        setListeners();
        setUpRecyclerView();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Product>> call = apiService.getProductsByStatusReady();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> products = response.body();
                    if (products != null) {
                        productSelectAdapter.setProducts(products);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void initView() {
        backImageView = findViewById(R.id.backImageView);
        productSelectRecyclerView = findViewById(R.id.productSelectRecyclerView);
    }

    private void setListeners() {
        backImageView.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());
    }

    private void setUpRecyclerView() {
        productSelectAdapter = new ProductSelectAdapter(this);
        productSelectRecyclerView.setAdapter(productSelectAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        productSelectRecyclerView.setLayoutManager(layoutManager);
        productSelectRecyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onItemProductSelected(Product product) {
        Intent intent = new Intent();
        intent.putExtra(PRODUCT_SELECTED_EXTRA, product);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}