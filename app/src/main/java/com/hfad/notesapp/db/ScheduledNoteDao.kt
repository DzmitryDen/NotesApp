package com.hfad.notesapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScheduledNoteDao {

    @Insert
    fun addScheduledNote(scheduledNote: ScheduledNoteEntity) // добавление заметки

    @Delete
    fun deleteScheduledNoteById(scheduledNote: ScheduledNoteEntity) // удаление заметки

    @Query("SELECT * FROM ScheduledNote")
    fun getAllScheduledNotes(): List<ScheduledNoteEntity> // получение всех заметок

    @Query("SELECT * FROM ScheduledNote WHERE id == :id LIMIT 1")
    fun getScheduledNoteById(id: Int): ScheduledNoteEntity // получение заметки по id
}