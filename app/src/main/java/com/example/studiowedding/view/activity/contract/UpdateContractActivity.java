package com.example.studiowedding.view.activity.contract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.studiowedding.R;
import com.example.studiowedding.interfaces.OnItemClickListner;

public class UpdateContractActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgBack;
    private EditText edPaymentStatus,edIncurrentStatus,edIncurrentNote,edFine,edDor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contract);
        imgBack=findViewById(R.id.imgBackFromUpdateContract);
        edPaymentStatus=findViewById(R.id.edUpdatePaymentStatusContract);
        edIncurrentStatus=findViewById(R.id.edUpdateIncurrentStatusContract);
        edIncurrentNote=findViewById(R.id.edUpdateIncurrentNoteContract);
        edFine=findViewById(R.id.edUpdateIncurrentFineContract);
        edDor=findViewById(R.id.edUpdateIncurrentDorContract);

        imgBack.setOnClickListener(this);
        edPaymentStatus.setOnClickListener(this);
        edIncurrentStatus.setOnClickListener(this);
        edIncurrentNote.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBackFromUpdateContract:
                finish();
                break;
            case R.id.edUpdatePaymentStatusContract:
                showPopupMenuPayment(view);
                break;
            case R.id.edUpdateIncurrentStatusContract:
                showPopupMenuIncurrent(view);
                break;
            case R.id.edUpdateIncurrentNoteContract:
                showPopupMenuIncurrentNote(view);
                break;
        }
    }

    private void showPopupMenuPayment(View v) {
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
    private void showPopupMenuIncurrent(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu_incurrent, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_incurent:
                        edIncurrentStatus.setText("Có phát sinh");
                        edIncurrentNote.setVisibility(View.VISIBLE);
                        edDor.setVisibility(View.GONE);
                        edFine.setVisibility(View.GONE);
                        return true;
                    case R.id.action_is_incurrent:
                        edIncurrentStatus.setText("Không có phát sinh");
                        edIncurrentNote.setVisibility(View.GONE);
                        edDor.setVisibility(View.GONE);
                        edFine.setVisibility(View.GONE);
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
    private void showPopupMenuIncurrentNote(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu_incurrent_note, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_damage:
                        edIncurrentNote.setText("Khách làm hỏng đồ");
                        edFine.setVisibility(View.VISIBLE);
                        edDor.setVisibility(View.GONE);
                        return true;
                    case R.id.action_is_late:
                        edIncurrentNote.setText("Khách trả đồ muộn");
                        edDor.setVisibility(View.VISIBLE);
                        edFine.setVisibility(View.VISIBLE);
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
}