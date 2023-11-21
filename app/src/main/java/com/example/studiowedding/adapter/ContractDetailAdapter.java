package com.example.studiowedding.adapter;

import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studiowedding.R;
import com.example.studiowedding.model.ContractDetail;

import java.util.List;

public class ContractDetailAdapter extends RecyclerView.Adapter<ContractDetailAdapter.ContractDetailViewHolder> {
    public static final String MENU_BODY_UPDATE_TITLE = "Cập nhật";
    public static final String MENU_BODY_DELETE_TITLE = "Xoá";
    public static final String MENU_HEADER_TITLE = "Menu";
    private List<ContractDetail> contractDetails;

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContractDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_detail_contract, parent, false);
        return new ContractDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContractDetailViewHolder holder, int position) {
        if (contractDetails != null) {
            ContractDetail contractDetail = contractDetails.get(position);
            /*
             * Nếu địa điểm null thì sẽ là HĐCT với gói sản phẩm
             * Ngược lại sẽ là HĐCT với gói dịch vụ
             */
            if (contractDetail.getLocation() == null) {
                // Hiển thị view HĐCt với gói sản phẩm
                holder.dateOfHireTextView.setVisibility(View.VISIBLE);
                holder.dateOfReturnTextView.setVisibility(View.VISIBLE);
                holder.productNameTextView.setVisibility(View.VISIBLE);
                holder.productPriceTextView.setVisibility(View.VISIBLE);

                // Gán dữ liệu cho view
                holder.dateOfHireTextView.setText(contractDetail.getDateOfHire());
                holder.dateOfReturnTextView.setText(contractDetail.getDateOfReturn());
                holder.productNameTextView.setText(contractDetail.getProductName());
                holder.productPriceTextView.setText(contractDetail.getProductPrice() + "");
            } else {
                // Hiển thị view HĐCT với dịch vụ
                holder.locationTextView.setVisibility(View.VISIBLE);
                holder.dateOfPerformTextView.setVisibility(View.VISIBLE);
                holder.serviceName.setVisibility(View.VISIBLE);
                holder.servicePrice.setVisibility(View.VISIBLE);

                // Gán dữ liệu cho view
                holder.locationTextView.setText(contractDetail.getLocation());
                holder.dateOfPerformTextView.setText(contractDetail.getDateOfPerform());
                holder.serviceName.setText(contractDetail.getServiceName());
                holder.servicePrice.setText(contractDetail.getServicePrice() + "");
            }

            holder.imgPopupMenuDetailContractItem.setOnClickListener(view -> {
                showAlertDialogMenuMore(holder, contractDetail);
            });
        }
    }

    @Override
    public int getItemCount() {
        return contractDetails == null ? 0 : contractDetails.size();
    }

    public static class ContractDetailViewHolder extends RecyclerView.ViewHolder {
        TextView locationTextView, dateOfPerformTextView, serviceName, servicePrice;
        TextView dateOfHireTextView, dateOfReturnTextView, productNameTextView, productPriceTextView;
        ImageView imgPopupMenuDetailContractItem;

        public ContractDetailViewHolder(@NonNull View itemView) {
            super(itemView);

            // View sản phẩm
            dateOfHireTextView = itemView.findViewById(R.id.dateOfHireTextView);
            dateOfReturnTextView = itemView.findViewById(R.id.dateOfReturnTextView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            dateOfHireTextView.setVisibility(View.GONE);
            dateOfReturnTextView.setVisibility(View.GONE);
            productNameTextView.setVisibility(View.GONE);
            productPriceTextView.setVisibility(View.GONE);

            // View dịch vụ
            locationTextView = itemView.findViewById(R.id.locationTextView);
            dateOfPerformTextView = itemView.findViewById(R.id.dateOfPerformTextView);
            serviceName = itemView.findViewById(R.id.serviceNameTextView);
            servicePrice = itemView.findViewById(R.id.servicePriceTextView);
            locationTextView.setVisibility(View.GONE);
            dateOfPerformTextView.setVisibility(View.GONE);
            serviceName.setVisibility(View.GONE);
            servicePrice.setVisibility(View.GONE);

            // Img menu
            imgPopupMenuDetailContractItem = itemView.findViewById(R.id.imgPopupMenuDetailContractItem);
        }
    }

    // Hiển thị menu tác vụ [Cập nhật] : [Xoá]
    private void showAlertDialogMenuMore(@NonNull ContractDetailViewHolder holder, ContractDetail contractDetail) {
        final CharSequence[] options = {MENU_BODY_UPDATE_TITLE, MENU_BODY_DELETE_TITLE};
        AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
        builder.setTitle(MENU_HEADER_TITLE)
                .setItems(options, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            Log.d("ContractAdapter", "onClick: Cập nhật" + contractDetail);
                            break;
                        case 1:
                            Log.d("ContractAdapter", "onClick: Xoá" + contractDetail);
                            break;
                        default:
                            break;
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
