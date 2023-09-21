package com.example.mvvm.BoundService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CalculatorService extends Service {

    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        CalculatorService getService() {
            return CalculatorService.this;
        }
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}

