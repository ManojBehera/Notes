package com.notes.di.module;

import android.app.Activity;
import android.content.Context;

import com.notes.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

}
