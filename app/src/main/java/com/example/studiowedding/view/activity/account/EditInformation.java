package com.example.studiowedding.view.activity.account;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.example.studiowedding.R;

import java.util.Calendar;

public class EditInformation extends AppCompatActivity {

    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_information);
        imgback = findViewById(R.id.imgBack);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


//        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
//                new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
//                        // Xử lý ngày được chọn
//                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
//                        // Hiển thị ngày đã chọn (bạn có thể làm điều gì đó khác với ngày này)
//                        yourTextView.setText(selectedDate);
//                    }
//                }, year, month, day);
//
//        datePickerDialog.show();
//
    }


}