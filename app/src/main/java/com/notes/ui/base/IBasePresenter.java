package com.notes.ui.base;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

public interface IBasePresenter<V extends IBaseView> {

    void onAttach(V mvpView);

    void onDetach();

}
