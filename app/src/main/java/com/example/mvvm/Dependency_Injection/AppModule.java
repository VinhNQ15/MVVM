package com.example.mvvm.Dependency_Injection;

import com.example.mvvm.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    public ApiService provideApiService() {
        return new ApiService();
    }

    @Provides
    public MainActivity provideMainActivity() {
        return new MainActivity();
    }
}
