package com.notes.ui.notes;

import com.notes.database.Notes;
import com.notes.repo.NotesDataRepository;
import com.notes.ui.base.BasePresenter;

import javax.inject.Inject;


/**
 * Created by dineshkumar.m on 11/11/17.
 */

public class AddNotesPresenter<V extends IAddNotesView> extends BasePresenter<V>
        implements IAddNotesPresenter<V> {

    @Inject
    public AddNotesPresenter() {

    }


    @Override
    public void addNote(NotesDataRepository repository, String addNote, String description) {

        Notes notes = new Notes();
        notes.setTitle(addNote);
        notes.setDescription(description);

        repository.insert(notes);

    }
}
