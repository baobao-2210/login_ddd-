package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; // <<< THÊM IMPORT NÀY
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Paint;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView tvRegister, tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        edtUsername = findViewById(R.id.editTextUsername);
        edtPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        // Thêm gạch chân cho TextView
        tvRegister.setPaintFlags(tvRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvForgotPassword.setPaintFlags(tvForgotPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // Xử lý nút Đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (username.equals("admin") && password.equals("123456")) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    // TODO: Chuyển sang màn hình chính của ứng dụng nếu cần
                } else {
                    Toast.makeText(MainActivity.this, "Sai tên đăng nhập hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý nút Đăng ký
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Chuyển sang màn hình Đăng ký", Toast.LENGTH_SHORT).show(); // Có thể bỏ dòng này
                Intent intent = new Intent(MainActivity.this, DangKy.class); // <<< SỬA Ở ĐÂY
                startActivity(intent); // <<< SỬA Ở ĐÂY
            }
        });

        // Xử lý nút Quên mật khẩu
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Chức năng Quên mật khẩu đang phát triển", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
