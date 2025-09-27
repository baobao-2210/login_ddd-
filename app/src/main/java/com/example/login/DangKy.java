package com.example.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangKy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ky);

        // Đảm bảo ID này khớp với ID của ConstraintLayout gốc trong activity_dang_ky.xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dangKyRootLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edtUsername = findViewById(R.id.editTextText);
        EditText edtPassword = findViewById(R.id.editTextTextPassword);
        EditText edtConfirmPassword = findViewById(R.id.editTextTextPassword2);
        Button btnRegister = findViewById(R.id.button);

        btnRegister.setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            String confirm = edtConfirmPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(DangKy.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirm)) {
                Toast.makeText(DangKy.this, "Mật khẩu xác nhận không khớp!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DangKy.this, "Đăng ký thành công cho: " + username, Toast.LENGTH_SHORT).show();
                // Sau khi đăng ký thành công, đóng Activity DangKy để quay lại MainActivity
                finish(); // <<< DÒNG NÀY SẼ ĐÓNG ACTIVITY HIỆN TẠI
            }
        });
        //baitap
    }
}
