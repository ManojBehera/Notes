package com.notes.di.component;

import android.app.Application;

import com.notes.NotesApplication;
import com.notes.database.NotesDao;
import com.notes.database.NotesDatabase;
import com.notes.di.module.ApplicationModule;
import com.notes.repo.NotesDataRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

@Singleton
@Component(dependencies = {}, modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(NotesApplication app);

    NotesDao notestDao();

    NotesDatabase notesDatabase();

    NotesDataRepository notesDataRepository();

    Application application();

}
