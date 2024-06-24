package com.hfad.notesapp.repositories

import android.widget.EditText
import com.hfad.notesapp.data.Note
import com.hfad.notesapp.data.ScheduledNote
import com.hfad.notesapp.db.NoteDataBase

class NoteRepository {

    fun addScheduledNote(title: EditText?, message: EditText?, date: EditText?) {
        NoteDataBase.noteList.add(
            ScheduledNote(
                title?.text.toString(),
                message?.text.toString(),
                date?.text.toString()
            )
        )
    }

    fun addNote(title: EditText?, message: EditText?) {
        NoteDataBase.noteList.add(
            Note(
                title?.text.toString(),
                message?.text.toString()
            )
        )
    }

    fun getNoteList() : ArrayList<Any>{
        return NoteDataBase.noteList
    }
}