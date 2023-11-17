package com.example.studiowedding.view.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.studiowedding.R;
import com.example.studiowedding.view.fragment.ServiceModel;

import java.util.ArrayList;
import java.util.List;

public class ServicesAdapter extends ArrayAdapter<ServiceModel> {

    public ServicesAdapter(Context context, int resource, List<ServiceModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_services, null);
        }

        // Get the data item for this position
        ServiceModel service = getItem(position);

        // Set the values for your three TextView elements
        TextView tvvaycuoi = view.findViewById(R.id.tvvaycuoi);
        TextView tvgiavay = view.findViewById(R.id.tvgiavay);
        TextView tvtrangthai = view.findViewById(R.id.tvtrangthai);

        if (service != null) {
            tvvaycuoi.setText(" " + service.getTenvaycuoi());
            tvgiavay.setText(" " + service.getGiatien());
            tvtrangthai.setText("" + service.getTrangthai());
        }
        // Dữ liệu giả
        List<ServiceModel> serviceList = new ArrayList<>();
        serviceList.add(new ServiceModel("Váy cưới 1", "9999999", "Chi tiết 1"));
        serviceList.add(new ServiceModel("Váy cưới 2", "999999", "Chi tiết 2"));
        serviceList.add(new ServiceModel("Váy cưới 3", "999999", "Chi tiết 3"));
        serviceList.add(new ServiceModel("Váy cưới 4", "999999", "Chi tiết 3"));
        serviceList.add(new ServiceModel("Váy cưới 5", "999999", "Chi tiết 3"));
        serviceList.add(new ServiceModel("Váy cưới 6", "999999", "Chi tiết 3"));
        serviceList.add(new ServiceModel("Váy cưới 7", "999999", "Chi tiết 3"));
        serviceList.add(new ServiceModel("Váy cưới 8", "999999", "Chi tiết 3"));


        return view;
    }
}
