package com.example.mvvm;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private boolean doubleClick = false;
    private EditText edtemail, edtpass;
    private TextView txtmesss ,txtpass;
    private Button btnlog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        edtemail = findViewById(R.id.edt_username);
        edtpass = findViewById(R.id.edt_pass);
        txtmesss = findViewById(R.id.text_Email);
        txtpass = findViewById(R.id.text_pass);
        btnlog = findViewById(R.id.btnlogin);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String strEmail= edtemail.getText().toString().trim();
        String strPass= edtpass.getText().toString().trim();
        if (strEmail.equals("thanhcong2kcs@gmail.com") && strPass.equals("123456789")) {
            Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, Home.class));

        }
        if (strEmail.isEmpty() ){
            txtmesss.setVisibility(View.VISIBLE);
            txtmesss.setText("Email can`t be blank");
            txtmesss.setTextColor(getResources().getColor(R.color.red));
//            Toast.makeText(MainActivity.this, "Emai trống", Toast.LENGTH_SHORT).show();
        }
        if (strPass.isEmpty() ){
            txtpass.setVisibility(View.VISIBLE);
            txtpass.setText("Password can`t be blank");
            txtpass.setTextColor(getResources().getColor(R.color.red));
////            Toast.makeText(MainActivity.this, "Password trống ", Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void onBackPressed() {
        if (doubleClick)
            finish();
        Toast.makeText(this, "Click 2 lần liên tiếp để thoát ứng dụng", Toast.LENGTH_SHORT).show();
        doubleClick = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleClick = false;
            }
        }, 2000);
    }
}


