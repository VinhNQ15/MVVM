package com.example.mvvm.MVC.controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvm.MVC.modal.User;
import com.example.mvvm.R;

public class ActivityController extends AppCompatActivity {
    private User user; // Model
    private TextView textViewName;
    private TextView textViewAge;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_controller);

        // Khởi tạo Model (Content)
        this.user = new User("John Doe", 30);

        // Liên kết các View từ giao diện
        this.textViewName = this.findViewById(R.id.textViewName);
        this.textViewAge = this.findViewById(R.id.textViewAge);

        // Cập nhật giao diện người dùng với dữ liệu từ Model
        this.updateUI();
    }

    private void updateUI() {
        // Hiển thị thông tin người dùng trên giao diện
        this.textViewName.setText("Name: " + this.user.getName());
        this.textViewAge.setText("Age: " + this.user.getAge());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}