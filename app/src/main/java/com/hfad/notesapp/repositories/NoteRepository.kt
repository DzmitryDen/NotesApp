package com.hfad.notesapp.repositories

import android.widget.EditText
import com.hfad.notesapp.data.Note
import com.hfad.notesapp.data.ScheduledNote
import com.hfad.notesapp.db.DataBaseProvider
import com.hfad.notesapp.db.NoteDataBase
import com.hfad.notesapp.db.NoteEntity
import com.hfad.notesapp.db.ScheduledNoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dataBaseProvider: DataBaseProvider,
    private val noteDataBase: NoteDataBase
) {

    fun addScheduledNote(title: EditText?, message: EditText?, date: EditText?) {
//        NoteDataBase.noteList.add(
//            ScheduledNote(
//                title?.text.toString(),
//                message?.text.toString(),
//                date?.text.toString()
//            )
//        )

        dataBaseProvider.scheduledNoteDao?.addScheduledNote(
            ScheduledNoteEntity(
                0,
                title?.text.toString(),
                message?.text.toString(),
                date?.text.toString()
            )
        )
    }

    fun addNote(title: EditText?, message: EditText?) {
//        NoteDataBase.noteList.add(
//            Note(
//                title?.text.toString(),
//                message?.text.toString()
//            )
//        )

        dataBaseProvider.noteDao?.addNote(
            NoteEntity(0, title?.text.toString(), message?.text.toString())
        )
    }

    fun getNoteList(): ArrayList<Any> {
        return noteDataBase.noteList
    }
}