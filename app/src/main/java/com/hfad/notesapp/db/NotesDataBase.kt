package com.hfad.notesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class, ScheduledNoteEntity::class], version = 1)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
    abstract fun getScheduledNoteDao(): ScheduledNoteDao
}