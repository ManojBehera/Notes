package com.notes.di.component;

import com.notes.ui.MainActivity;
import com.notes.di.PerActivity;
import com.notes.di.module.ActivityModule;
import com.notes.ui.notes.AddNotesActivity;

import dagger.Component;

/**
 * Created by dineshkumar.m on 11/11/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(AddNotesActivity activity);
}
