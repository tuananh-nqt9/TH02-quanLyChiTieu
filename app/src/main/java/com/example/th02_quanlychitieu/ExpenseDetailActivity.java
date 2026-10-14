package com.example.th02_quanlychitieu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class ExpenseDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail);

        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvAmount = findViewById(R.id.tvDetailAmount);
        TextView tvCategory = findViewById(R.id.tvDetailCategory);
        TextView tvDate = findViewById(R.id.tvDetailDate);
        TextView tvNote = findViewById(R.id.tvDetailNote);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnDelete = findViewById(R.id.btnDelete);

        Expense e = (Expense) getIntent().getSerializableExtra("expense");
        int position = getIntent().getIntExtra("position", -1);

        if (e != null) {
            tvName.setText(e.getTenKhoanChi());
            tvCategory.setText(e.getDanhMuc());
            tvDate.setText(e.getNgayChiTieu());
            tvNote.setText(e.getGhiChu().isEmpty() ? "Không có ghi chú" : e.getGhiChu());

            DecimalFormat df = new DecimalFormat("#,### đ");
            tvAmount.setText(df.format(e.getSoTien()));
        }

        btnBack.setOnClickListener(v -> finish());

        btnDelete.setOnClickListener(v -> {
            if (position != -1) {
                DataStore.expenseList.remove(position);
                Toast.makeText(this, "Đã xóa khoản chi", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}