package com.example.studiowedding.view.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.studiowedding.R;
import com.example.studiowedding.view.activity.employee.AddEmployeeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class EmployeeFragment extends Fragment {

    FloatingActionButton floatingActionButton;
    ImageView ivFilter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        floatingActionButton = view.findViewById(R.id.fabContract);
        ivFilter = view.findViewById(R.id.imgFilterContract);
        floatingActionButton.setOnClickListener(view1 -> startActivity(new Intent(getContext(), AddEmployeeActivity.class)));
    }
}