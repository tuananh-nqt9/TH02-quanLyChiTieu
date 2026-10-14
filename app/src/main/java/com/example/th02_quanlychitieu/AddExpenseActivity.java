package com.example.th02_quanlychitieu;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AddExpenseActivity extends AppCompatActivity {
    private EditText edtName, edtAmount, edtNote;
    private Spinner spCategory;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        edtName = findViewById(R.id.edtAddName);
        edtAmount = findViewById(R.id.edtAddAmount);
        edtNote = findViewById(R.id.edtAddNote);
        spCategory = findViewById(R.id.spCategory);
        tvDate = findViewById(R.id.tvAddDate);
        Button btnSave = findViewById(R.id.btnSaveExpense);

        Calendar cal = Calendar.getInstance();
        tvDate.setText(cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));

        tvDate.setOnClickListener(v -> {
            DatePickerDialog d = new DatePickerDialog(AddExpenseActivity.this,
                    (view, year, month, dayOfMonth) -> tvDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year),
                    cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
            d.show();
        });

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String amountStr = edtAmount.getText().toString().trim();
            String category = spCategory.getSelectedItem().toString();
            String date = tvDate.getText().toString();
            String note = edtNote.getText().toString().trim();

            boolean hasError = false;

            if (name.isEmpty()) {
                edtName.setError("Tên khoản chi không được để trống");
                hasError = true;
            }

            if (amountStr.isEmpty()) {
                edtAmount.setError("Số tiền không được để trống");
                hasError = true;
            } else {
                double amount = Double.parseDouble(amountStr);
                if (amount <= 0) {
                    edtAmount.setError("Số tiền phải lớn hơn 0");
                    hasError = true;
                }
            }

            if (hasError) {
                return;
            }

            // Nếu không có lỗi thì lưu bình thường
            double finalAmount = Double.parseDouble(amountStr);
            DataStore.expenseList.add(new Expense(name, finalAmount, category, date, note));
            Toast.makeText(this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}