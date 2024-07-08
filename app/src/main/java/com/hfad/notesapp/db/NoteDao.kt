package com.hfad.notesapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun addNote(scheduledNote: NoteEntity) // добавление заметки

    @Delete
    fun deleteNoteById(scheduledNote: NoteEntity) // удаление заметки по id

    @Query("SELECT * FROM Note")
    fun getAllNotes(): List<NoteEntity> // получение всех заметок

    @Query("SELECT * FROM Note WHERE id == :id LIMIT 1")
    fun getScheduledNoteById(id: Int): NoteEntity // получение заметки по id
}