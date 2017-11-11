package com.notes.repo;

import com.notes.database.Notes;

import java.util.List;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

public interface NotesDataRepository {

    void insert(Notes product);

    List<Notes> fetchAllData();
}
