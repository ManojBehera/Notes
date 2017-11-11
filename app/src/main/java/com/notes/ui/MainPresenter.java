package com.notes.ui;

import com.notes.ui.base.BasePresenter;

import javax.inject.Inject;


/**
 * Created by dineshkumar.m on 11/11/17.
 */

public class MainPresenter<V extends IMainView> extends BasePresenter<V>
        implements IMainPresenter<V> {

    @Inject
    public MainPresenter() {

    }

    @Override
    public void getNotesList(int page, boolean showProgress, boolean isInitialLoad, boolean isDelete) {

    }
}
