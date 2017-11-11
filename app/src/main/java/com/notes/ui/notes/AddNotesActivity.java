package com.notes.ui.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.notes.R;
import com.notes.repo.NotesDataRepository;
import com.notes.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddNotesActivity extends BaseActivity implements IAddNotesView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.addnote_title)
    EditText mTitle;

    @BindView(R.id.addnote_more)
    EditText mDescription;

    @BindView(R.id.fab)
    FloatingActionButton mBtnSubmit;


    int assetId;
    String barcode;

    @Inject
    public NotesDataRepository notesDataRepository;

    @Inject
    AddNotesPresenter<IAddNotesView> mAddNotePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getActivityComponent().inject(this);

        mAddNotePresenter.onAttach(this);

        setUnBinder(ButterKnife.bind(this));

        setUp();


    }

    @OnClick(R.id.fab)
    void submit(View view){
        if(!TextUtils.isEmpty(mTitle.getText().toString()) && !TextUtils.isEmpty(mDescription.getText().toString())) {

            mAddNotePresenter.addNote(notesDataRepository,mTitle.getText().toString(),mDescription.getText().toString());

            finishActivity();

        }else{
            Toast.makeText(this,"Please enter title and description!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("Add Note");
        mToolbar.setNavigationIcon(R.drawable.ic_action_up);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                finishActivity();
            }
        });
    }

    @Override
    public void finishActivity() {
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
