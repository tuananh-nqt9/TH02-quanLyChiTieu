package com.example.th02_quanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tvTotalAmount;
    private RecyclerView rvExpenses;
    private Button btnAddExpense;
    private ExpenseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataStore.initData();

        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        rvExpenses = findViewById(R.id.rvExpenses);
        btnAddExpense = findViewById(R.id.btnAddExpense);

        rvExpenses.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExpenseAdapter(this, DataStore.expenseList);
        rvExpenses.setAdapter(adapter);

        btnAddExpense.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddExpenseActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        double total = 0;
        for (Expense e : DataStore.expenseList) {
            total += e.getSoTien();
        }
        DecimalFormat df = new DecimalFormat("#,### đ");
        tvTotalAmount.setText(df.format(total));
    }
}