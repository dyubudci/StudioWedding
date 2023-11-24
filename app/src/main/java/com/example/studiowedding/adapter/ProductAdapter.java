package com.example.studiowedding.adapter;// ExampleAdapter.java
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studiowedding.R; // Thêm dòng này nếu chưa thêm
import com.example.studiowedding.interfaces.OnItemClickListner;
import com.example.studiowedding.model.Product;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ExampleViewHolder> {
    private List<Product> dataList;
    private OnItemClickListner.Child mOnClickItem;
    ImageView img_pop_product;

    public ProductAdapter(List<Product> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ExampleViewHolder(view);
    }
    public void setOnClickItem(OnItemClickListner.Child mOnClickItem){
        this.mOnClickItem = mOnClickItem;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product currentItem = dataList.get(position);

        holder.tvvaycuoi.setText(currentItem.getTvvaycuoi());
        holder.tvtrangthai.setText(currentItem.getTvtrangthai());
        holder.tvgiavay.setText(String.valueOf(currentItem.getTvgiavay()));

        holder.img_pop_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị PopupMenu ở đây
                PopupMenu popupMenu = new PopupMenu(v.getContext(), holder.img_pop_product);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu_product, popupMenu.getMenu());

                // Thêm sự kiện xử lý cho MenuItem pop_product_delete
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.Pop_product_delete) {
                            // Hiển thị hộp thoại xác nhận xóa
                            showDeleteConfirmationDialog(v.getContext(), currentItem, position);
                            return true;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView tvvaycuoi;
        public TextView tvtrangthai;
        public TextView tvgiavay;
        public ImageView img_pop_product; // Thêm dòng này

        public ExampleViewHolder(View itemView) {
            super(itemView);
            tvvaycuoi = itemView.findViewById(R.id.tvvaycuoi);
            tvtrangthai = itemView.findViewById(R.id.tvtrangthai);
            tvgiavay = itemView.findViewById(R.id.tvgiavay);
            img_pop_product = itemView.findViewById(R.id.img_pop_product); // Thêm dòng này
        }
    }

    private void showDeleteConfirmationDialog(Context context, Product product, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xác nhận xóa");
        builder.setMessage("Trạng thái: " + product.getTvtrangthai() + "\nBạn có chắc muốn xóa sản phẩm này không?");

        // Nút xác nhận xóa
        builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Thực hiện xóa sản phẩm ở đây
                // Gọi một phương thức để xử lý xóa sản phẩm, có thể làm thông qua interface
                if (mOnClickItem != null) {
                    mOnClickItem.onDeleteButtonClick(position);
                }

                // Hiển thị thông báo "Đã xóa thành công"
                showDeleteSuccessMessage(context);
            }
        });

        // Nút hủy
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Đóng hộp thoại khi nhấn nút Hủy
                dialog.dismiss();
            }
        });

        // Hiển thị hộp thoại
        builder.show();
    }
    private void showDeleteSuccessMessage(Context context) {
        Snackbar.make(((Activity) context).findViewById(android.R.id.content),
                "Đã xóa thành công", Snackbar.LENGTH_SHORT).show();
    }


}
