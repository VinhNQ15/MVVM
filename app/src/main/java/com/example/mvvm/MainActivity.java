package com.example.mvvm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvm.Home.Home;

public class MainActivity extends AppCompatActivity {

    private boolean doubleClick = false;
    private EditText edtemail, edtpass;
    private TextView txtmesss, txtpass;
    private Button btnlog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtemail = findViewById(R.id.edt_username);
        edtpass = findViewById(R.id.edt_pass);
        txtmesss = findViewById(R.id.text_Email);
        txtpass = findViewById(R.id.text_pass);
        btnlog = findViewById(R.id.btnlogin);
        btnlog.setOnClickListener(view -> clickLogin());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Home.class));
            }
        }, 300);
    }

    private void clickLogin() {
        startActivity(new Intent(MainActivity.this, Home.class));
//        String strEmail= edtemail.getText().toString().trim();
//        String strPass= edtpass.getText().toString().trim();
//        if (strEmail.equals("1") && strPass.equals("1")) {
//            Toast.makeText(MainActivity.this, "Đăng nhập thành công  ", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(MainActivity.this, Home.class));
//        }
//        if (strEmail.isEmpty() ){
//            txtmesss.setVisibility(View.VISIBLE);
//            txtmesss.setText("Email can`t be blank");
//            txtmesss.setTextColor(getResources().getColor(R.color.red));
//        }
//        if (strPass.isEmpty() ){
//            txtpass.setVisibility(View.VISIBLE);
//            txtpass.setText("Password can`t be blank");
//            txtpass.setTextColor(getResources().getColor(R.color.red));
//        }
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


