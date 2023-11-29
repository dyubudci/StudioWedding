package com.example.studiowedding.view.activity.product;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.studiowedding.R;
import com.example.studiowedding.databinding.ActivityAddProductBinding;
import com.example.studiowedding.model.Product;
import com.example.studiowedding.network.ApiClient;
import com.example.studiowedding.network.ApiService;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.io.ByteArrayOutputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductActivity extends AppCompatActivity {
    ActivityAddProductBinding viewBinding;
    Product product = null;
    String base64Image;
    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;

    @Override
    protected void onStart() {
        pickMedia =
                registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                    if (uri != null) {
                        Glide.with(AddProductActivity.this)
                                .asBitmap()
                                .load(uri)
                                .into(new CustomTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                        base64Image = encodeImageToBase64(resource);
                                        viewBinding.imgPopProduct.setImageBitmap(resource);
                                    }

                                    @Override
                                    public void onLoadCleared(@Nullable Drawable placeholder) {
                                    }
                                });

                        Log.d("PhotoPicker", "Selected URI: " + uri);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                });
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        viewBinding = ActivityAddProductBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        product = (Product) getIntent().getSerializableExtra("product");
        if (product != null) {
            viewBinding.edProductName.setText(product.getName());
            viewBinding.edProductPrice.setText(product.getPrice() + "");
            viewBinding.btnAddProduct.setText("Cập nhật");
        }
        requestPermission();
        viewBinding.spStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setContentView(viewBinding.getRoot());
    }

    @Override
    protected void onResume() {
        String[] productArray = getResources().getStringArray(R.array.product_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, productArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewBinding.spProduct.setAdapter(adapter);
        String[] productArray2 = getResources().getStringArray(R.array.product_type_array);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, productArray2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewBinding.spStatus.setAdapter(adapter2);
        viewBinding.btnAddProduct.setOnClickListener(v -> {
            if (product != null) {
                updateProduct();
                return;
            }
            addProduct();
        });
        viewBinding.cvProduct.setOnClickListener(v -> {
            getImage();
        });
        super.onResume();
    }

    void getImage() {
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                .build());
    }

    void requestPermission() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(AddProductActivity.this, "Quyền hình ảnh được chấp nhận", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(AddProductActivity.this, "Quyền hình ảnh bị từ chối" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };
        TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();
    }

    void addProduct() {
        if (viewBinding.edProductPrice.getText().length() == 0 || viewBinding.edProductName.getText().length() == 0) {
            Toast.makeText(this, "Vui lòng điền đủ trường", Toast.LENGTH_SHORT).show();
            return;
        }
        ApiClient.getClient().create(ApiService.class).addProduct(new Product(
                        viewBinding.edProductName.getText().toString(),
                        Float.parseFloat(viewBinding.edProductPrice.getText().toString()),
                (String) viewBinding.spStatus.getSelectedItem(),
                        (String) viewBinding.spProduct.getSelectedItem(),
                        base64Image

                )).
                enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(AddProductActivity.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                        AddProductActivity.this.finish();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(AddProductActivity.this, "Lỗi khi thêm sản phẩm", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    void updateProduct() {
        if (viewBinding.edProductPrice.getText().length() == 0 || viewBinding.edProductName.getText().length() == 0) {
            Toast.makeText(this, "Vui lòng điền đủ trường", Toast.LENGTH_SHORT).show();
            return;
        }
        ApiClient.getClient().create(ApiService.class).updateProduct(product.getId() + "", new Product(
                        viewBinding.edProductName.getText().toString(),
                        Float.parseFloat(viewBinding.edProductPrice.getText().toString()),
                        (String) viewBinding.spStatus.getSelectedItem(),
                        (String) viewBinding.spProduct.getSelectedItem(),
                        base64Image)).
                enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(AddProductActivity.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                        AddProductActivity.this.finish();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(AddProductActivity.this, "Lỗi khi thêm sản phẩm", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private String encodeImageToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }
}