package com.notes.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by dineshkumar.m on 11/11/17.
 */

@Dao
public interface NotesDao {

    @Insert
    void insertMultipleRecord(Notes... notes);

    @Insert
    void insertMultipleListRecord(List<Notes> notes);

    @Insert
    void insertOnlySingleRecord(Notes notes);

    @Query("SELECT * FROM Notes")
    List<Notes> fetchAllData();


    @Update
    void updateRecord(Notes notes);

    @Delete
    void deleteRecord(Notes notes);
}
