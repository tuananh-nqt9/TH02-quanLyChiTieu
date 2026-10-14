package com.example.th02_quanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private TextView tvError;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        tvError = findViewById(R.id.tvError);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> {
            String user = edtUsername.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            tvError.setVisibility(View.GONE);

            if (user.isEmpty()) {
                edtUsername.setError("Không được để trống");
                return;
            }
            if (pass.isEmpty()) {
                edtPassword.setError("Không được để trống");
                return;
            }

            if (user.equals("admin") && pass.equals("123456")) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                tvError.setVisibility(View.VISIBLE);
                Toast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}