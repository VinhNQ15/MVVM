package com.example.mvvm.BoundService;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvvm.R;
public class CalculatorActivity extends AppCompatActivity {

    private CalculatorService calculatorService;
    private boolean isBound = false;
    private EditText resultEditText;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CalculatorService.LocalBinder binder = (CalculatorService.LocalBinder) iBinder;
            calculatorService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            calculatorService = null;
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultEditText = findViewById(R.id.resultEditText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, CalculatorService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
    }

    public void addNumbers(View view) {
        if (isBound) {
            int num1 = Integer.parseInt(getString(R.id.num1EditText));
            int num2 = Integer.parseInt(getString(R.id.num2EditText));
            int result = calculatorService.add(num1, num2);
            resultEditText.setText(String.valueOf(result));
        }
    }

    public void subtractNumbers(View view) {
        if (isBound) {
            int num1 = Integer.parseInt(getString(R.id.num1EditText));
            int num2 = Integer.parseInt(getString(R.id.num2EditText));
            int result = calculatorService.subtract(num1, num2);
            resultEditText.setText(String.valueOf(result));
        }
    }
}

