package com.hfad.notesapp.db

import android.content.Context
import androidx.room.Room

object DataBaseProvider {

    var noteDao: NoteDao? = null
    var scheduledNoteDao: ScheduledNoteDao? = null

    fun init(context: Context) {

        val dataBase: NotesDataBase = Room.databaseBuilder(context, NotesDataBase::class.java, "app_data_base")
            .allowMainThreadQueries()
            .build()

        noteDao = dataBase.getNoteDao()
        scheduledNoteDao = dataBase.getScheduledNoteDao()
    }
}