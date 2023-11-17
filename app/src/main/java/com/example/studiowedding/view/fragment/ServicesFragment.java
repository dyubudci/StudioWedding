package com.example.studiowedding.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.studiowedding.R;
import com.example.studiowedding.adapter.TabServiceAdapter;
import com.example.studiowedding.model.Services;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ServicesFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    List<Services> list = new ArrayList<>();

    public ServicesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager2 = view.findViewById(R.id.vp_service);


//        mAdapter = new MyRecyclerViewAdapter(dataSanPham, null); // Ban đầu hiển thị dữ liệu của "Sản Phẩm"
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(mAdapter);

        TabServiceAdapter adapter = new TabServiceAdapter(getActivity());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0 :
                    tab.setText("Dịch vụ");
                    break;
                case 1 :
                    tab.setText("Sản phẩm");
                    break;

            }
        });

        return view;
    }
}
