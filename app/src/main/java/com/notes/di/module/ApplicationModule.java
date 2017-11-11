package com.notes.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.notes.database.NotesDao;
import com.notes.database.NotesDatabase;
import com.notes.di.ApplicationContext;
import com.notes.repo.NotesDataRepository;
import com.notes.repo.NotesDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    private NotesDatabase demoDatabase;

    public ApplicationModule(Application application) {
        mApplication = application;
        demoDatabase = Room.databaseBuilder(mApplication, NotesDatabase.class, "demo-db")
                .allowMainThreadQueries().build();
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Singleton
    @Provides
    NotesDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Singleton
    @Provides
    NotesDao providesNotesDao(NotesDatabase demoDatabase) {
        return demoDatabase.getNotesDao();
    }

    @Singleton
    @Provides
    NotesDataRepository notesDataRepository(NotesDao productDao) {
        return new NotesDataSource(productDao);
    }

}