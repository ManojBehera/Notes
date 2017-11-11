package com.notes.ui.base;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;


public class BaseFragment extends Fragment implements IBaseView {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
