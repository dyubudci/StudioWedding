package com.example.studiowedding.view.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.studiowedding.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductModel> {


    public ProductAdapter(Context context, int itemProduct, List<ProductModel> productList) {
        super(context, itemProduct);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_product, null);
        }

        // Get the data item for this position
        ProductModel service = getItem(position);

        // Set the values for your three TextView elements
        TextView chupanhcuoi = view.findViewById(R.id.tvchupanhcuoi);
        TextView tvgiavay = view.findViewById(R.id.tvgiavay);
        TextView tvtrangthai = view.findViewById(R.id.tvtrangthai);

        if (service != null) {
            chupanhcuoi.setText(" " + service.getChupanhcuoi());
            tvgiavay.setText(" " + service.getgiavay());
        }
        // Dữ liệu giả
        List<ProductModel> productList = new ArrayList<>();
        productList.add(new ProductModel("Váy cưới 1", "9999999"));
        productList.add(new ProductModel("Váy cưới 2", "999999" ));
        productList.add(new ProductModel("Váy cưới 3", "999999" ));
        productList.add(new ProductModel("Váy cưới 4", "999999"));
        productList.add(new ProductModel("Váy cưới 5", "999999" ));
        productList.add(new ProductModel("Váy cưới 6", "999999"));
        productList.add(new ProductModel("Váy cưới 7", "999999" ));
        productList.add(new ProductModel("Váy cưới 8", "999999" ));


        return view;
    }
}
