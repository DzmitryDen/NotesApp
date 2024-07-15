package com.hfad.notesapp.db

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DataBaseProvider @Inject constructor(@ApplicationContext context: Context) {

    var noteDao: NoteDao? = null
    var scheduledNoteDao: ScheduledNoteDao? = null

    init {

        val dataBase: NotesDataBase =
            Room.databaseBuilder(context, NotesDataBase::class.java, "app_data_base")
                .allowMainThreadQueries()
                .build()

        noteDao = dataBase.getNoteDao()
        scheduledNoteDao = dataBase.getScheduledNoteDao()
    }
}