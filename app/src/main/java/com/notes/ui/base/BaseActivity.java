package com.notes.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.notes.di.DependencyInjector;
import com.notes.di.component.ActivityComponent;
import com.notes.di.component.DaggerActivityComponent;
import com.notes.di.module.ActivityModule;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {


    private ActivityComponent mActivityComponent;

    private Unbinder mUnBinder;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(DependencyInjector.instance())
                .build();


    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }




    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();


    @Override
    public void onStop() {
        super.onStop();
    }

}
