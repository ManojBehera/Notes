package com.notes.ui.notes;

import com.notes.di.PerActivity;
import com.notes.repo.NotesDataRepository;
import com.notes.ui.base.IBasePresenter;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

@PerActivity
public interface IAddNotesPresenter<V extends IAddNotesView> extends IBasePresenter<V> {
    void addNote(NotesDataRepository repository, String addNote, String description);
}
