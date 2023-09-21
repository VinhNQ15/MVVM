package com.example.mvvm.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.mvvm.Dependency_Injection.ApiService;
import com.example.mvvm.Dependency_Injection.AppComponent;
import com.example.mvvm.Dependency_Injection.DaggerAppComponent;
import com.example.mvvm.MainActivity;
import com.example.mvvm.R;

import javax.inject.Inject;

public class HomeFragment extends Fragment {
    @Inject
    ApiService apiService;
    @Inject
    MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AppComponent component = DaggerAppComponent.create();
        component.inject(this);
        String data = apiService.fetchData();
        Log.d("MainActivity", "Fetched data: " + data);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}