package com.notes.ui;


import com.notes.di.PerActivity;
import com.notes.ui.base.IBasePresenter;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

@PerActivity
public interface IMainPresenter<V extends IMainView> extends IBasePresenter<V> {

    void getNotesList(int page, boolean showProgress, boolean isInitialLoad, boolean isDelete);

}
