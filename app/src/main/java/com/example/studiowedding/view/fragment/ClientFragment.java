package com.example.studiowedding.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studiowedding.R;
import com.example.studiowedding.adapter.ListClientAdapter;
import com.example.studiowedding.model.ListclientModel;

import java.util.ArrayList;


public class ClientFragment extends Fragment {

    private RecyclerView recyclerViewCustomersList;
    private RecyclerView.Adapter adapter;



    public ClientFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewCustomersList = view.findViewById(R.id.RVCustomers);
        recyclerViewCustomersList.setLayoutManager(linearLayoutManager);
        ArrayList<ListclientModel> listCustomer = new ArrayList<>();
        listCustomer.add(new ListclientModel("Cuong", "+ 888888888", "Đà nẵng"));
        listCustomer.add(new ListclientModel("Cuong1", "+ 888888888", "Đà nẵng"));
        listCustomer.add(new ListclientModel("Cuong2", "+ 888888888", "Đà nẵng"));
        adapter = new ListClientAdapter(listCustomer);
        recyclerViewCustomersList.setAdapter(adapter);

        return view;

    }
}