package com.notes.repo;

import com.notes.database.Notes;
import com.notes.database.NotesDao;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

public class NotesDataSource implements NotesDataRepository{

    private NotesDao notesDao;

    @Inject
    public NotesDataSource(NotesDao notesDao) {
        this.notesDao = notesDao;
    }

    @Override
    public void insert(final Notes notes) {
        notesDao.insertOnlySingleRecord(notes);
    }

    @Override
    public List<Notes> fetchAllData() {
        return notesDao.fetchAllData();
    }
}
