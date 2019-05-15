package com.crucial.a2019_alc_notekeeper;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {

    @Test
    public void createNewNote() throws Exception{
        final DataManager dataManager = DataManager.getInstance();
        final CourseInfo course = dataManager.getCourse("android_async");
        final String noteTittle = "Test note title";
        final String noteText = "This is the body of my test note";

        int noteIndex = dataManager.createNewNote();
        NoteInfo newNote = dataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTittle);
        newNote.setText(noteText);

        NoteInfo compareNote = dataManager.getNotes().get(noteIndex);

        assertEquals(course,compareNote.getCourse());
        assertEquals(noteTittle,compareNote.getTitle());
        assertEquals(noteText,compareNote.getText());

        assertSame(newNote,compareNote);

    }
}