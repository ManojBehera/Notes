package com.notes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.notes.R;
import com.notes.database.Notes;
import com.notes.repo.NotesDataRepository;
import com.notes.ui.base.BaseActivity;
import com.notes.ui.notes.AddNotesActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IMainView{

    @Inject
    MainPresenter<IMainView> mPresenter;

    @Inject
    public NotesDataRepository notesDataRepository;

    @BindView(R.id.fab)
    FloatingActionButton mBtnSubmit;

    private CustomListFragment mCustomListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);


        setUp();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, mCustomListFragment = CustomListFragment.newInstance(), CustomListFragment.class.getName())
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCustomListFragment.setData(notesDataRepository.fetchAllData());
        for(Notes notes :  notesDataRepository.fetchAllData()){
            Log.d("Notes updated","Title : "+notes.getTitle());
            Log.d("Notes updated","Description : "+notes.getDescription());
        }
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.fab)
    void submit(View view){
        openNotesCreateActivity();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openNotesCreateActivity() {
        startActivity(new Intent(this, AddNotesActivity.class));
    }

    @Override
    public void notifyDataSetChanged() {

    }
}
