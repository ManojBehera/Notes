package com.notes;

import android.app.Application;

import com.notes.di.DependencyInjector;
import com.notes.di.component.ApplicationComponent;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

public class NotesApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        DependencyInjector.initDaggerDependencies(this);

        ApplicationComponent applicationComponent = DependencyInjector.instance();

        applicationComponent.inject(this);

    }
}
