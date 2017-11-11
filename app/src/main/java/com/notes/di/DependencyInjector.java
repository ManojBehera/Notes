package com.notes.di;

import android.app.Application;

import com.notes.di.component.ApplicationComponent;
import com.notes.di.component.DaggerApplicationComponent;
import com.notes.di.module.ApplicationModule;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

public class DependencyInjector {

    private static ApplicationComponent appComponent;

    public static void initDaggerDependencies(Application appContext) {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(appContext))
                .build();
    }

    public static ApplicationComponent instance() {
        return appComponent;
    }
}
