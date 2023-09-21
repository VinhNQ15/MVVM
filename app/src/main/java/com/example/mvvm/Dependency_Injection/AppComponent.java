package com.example.mvvm.Dependency_Injection;

import com.example.mvvm.Home.HomeFragment;
import com.example.mvvm.MainActivity;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(HomeFragment homeFragment);

    void inject(MainActivity mainActivity);
}
