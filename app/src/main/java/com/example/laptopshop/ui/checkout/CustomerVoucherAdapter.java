package com.example.laptopshop.ui.checkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laptopshop.R;
import com.example.laptopshop.data.model.GiamGia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CustomerVoucherAdapter extends RecyclerView.Adapter<CustomerVoucherAdapter.ViewHolder> {

    public interface OnVoucherSelectedListener {
        void onVoucherSelected(GiamGia voucher);
    }

    private final ArrayList<GiamGia> list = new ArrayList<>();
    private final OnVoucherSelectedListener listener;
    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private int currentSubtotal = 0;

    public CustomerVoucherAdapter(OnVoucherSelectedListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<GiamGia> data, int subtotal) {
        this.currentSubtotal = subtotal;
        list.clear();
        if (data != null) list.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer_voucher_selectable, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GiamGia v = list.get(position);
        holder.tvCode.setText(v.code);
        holder.tvDescription.setText(String.format(Locale.getDefault(), "Giảm %,dđ", v.discountAmount));
        
        String conditionText = String.format(Locale.getDefault(), "Đơn từ %,dđ", v.minOrderValue);
        if (v.productId != null && v.productName != null) {
            conditionText += " • Áp dụng cho " + v.productName;
        }
        holder.tvCondition.setText(conditionText);
        
        holder.tvExpiry.setText("Hạn dùng: " + df.format(new Date(v.expiryDate)));

        // Kiểm tra điều kiện đơn hàng tối thiểu
        boolean isEligible = currentSubtotal >= v.minOrderValue;
        
        if (isEligible) {
            holder.itemView.setAlpha(1.0f);
            holder.btnSelect.setEnabled(true);
            View.OnClickListener clickListener = view -> listener.onVoucherSelected(v);
            holder.itemView.setOnClickListener(clickListener);
            holder.btnSelect.setOnClickListener(clickListener);
            holder.tvCondition.setTextColor(holder.itemView.getContext().getColor(R.color.text_sub));
        } else {
            holder.itemView.setAlpha(0.5f); // Làm mờ voucher không đủ điều kiện
            holder.btnSelect.setEnabled(false);
            holder.itemView.setOnClickListener(view -> {
                android.widget.Toast.makeText(view.getContext(), 
                    "Đơn hàng chưa đạt giá trị tối thiểu " + String.format(Locale.getDefault(), "%,dđ", v.minOrderValue), 
                    android.widget.Toast.LENGTH_SHORT).show();
            });
            holder.btnSelect.setOnClickListener(null);
            holder.tvCondition.setTextColor(holder.itemView.getContext().getColor(R.color.admin_danger));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCode, tvDescription, tvCondition, tvExpiry;
        View btnSelect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tvVoucherCode);
            tvDescription = itemView.findViewById(R.id.tvVoucherDescription);
            tvCondition = itemView.findViewById(R.id.tvVoucherCondition);
            tvExpiry = itemView.findViewById(R.id.tvVoucherExpiry);
            btnSelect = itemView.findViewById(R.id.btnSelect);
        }
    }
}
