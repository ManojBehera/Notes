package com.notes.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notes.R;
import com.notes.database.Notes;
import com.notes.ui.base.BaseFragment;

import java.util.List;


public class CustomListFragment extends BaseFragment {


    private MyRecyclerViewAdapter adapter;
    private List<Notes> mNoteList;

    interface Listener{
        void load(int page);
        void onItemDelete(String barcode, int asset_id);
    }

    public static CustomListFragment newInstance() {
        return new CustomListFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setData(List<Notes> notesList){
        this.mNoteList = notesList;
        adapter.setData(notesList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_notes_list, container, false);

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new MyRecyclerViewAdapter(getActivity(), mNoteList);
        recyclerView.setAdapter(adapter);

        return root;
    }

}
