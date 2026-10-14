package com.example.th02_quanlychitieu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {
    private Context context;
    private ArrayList<Expense> list;

    public ExpenseAdapter(Context context, ArrayList<Expense> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = list.get(position);
        holder.tvName.setText(expense.getTenKhoanChi());
        holder.tvCategory.setText(expense.getDanhMuc());
        holder.tvDate.setText(expense.getNgayChiTieu());

        DecimalFormat df = new DecimalFormat("#,### đ");
        holder.tvAmount.setText(df.format(expense.getSoTien()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ExpenseDetailActivity.class);
            intent.putExtra("expense", expense);
            intent.putExtra("position", position);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAmount, tvCategory, tvDate;
        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvItemName);
            tvAmount = itemView.findViewById(R.id.tvItemAmount);
            tvCategory = itemView.findViewById(R.id.tvItemCategory);
            tvDate = itemView.findViewById(R.id.tvItemDate);
        }
    }
}