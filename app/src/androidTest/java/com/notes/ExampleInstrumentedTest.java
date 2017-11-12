package com.notes;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.notes.database.Notes;
import com.notes.database.NotesDatabase;
import com.notes.repo.NotesDataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final Notes NOTES = new Notes();

    private NotesDatabase mDatabase;
    private NotesDataSource mDataSource;

    @Before
    public void initDb() throws Exception {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                NotesDatabase.class).build();
        mDataSource = new NotesDataSource(mDatabase.getNotesDao());
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void insertAndGetUser() {
        // When inserting a new user in the data source

        NOTES.setId(123);
        NOTES.setTitle("Test 123");
        NOTES.setTitle("Test 123 - Description");

        mDataSource.insert(NOTES);

        //The user can be retrieved
        Notes dbUser = mDataSource.fetchAllData().get(0);
        assertEquals(dbUser.getId(), NOTES.getId());
        assertEquals(dbUser.getTitle(), NOTES.getTitle());
        assertEquals(dbUser.getDescription(), NOTES.getDescription());
    }



    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.notes", appContext.getPackageName());
    }
}
