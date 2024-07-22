package com.hfad.notesapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(scheduledNote: NoteEntity) // добавление заметки

    @Delete
    suspend fun deleteNoteById(scheduledNote: NoteEntity) // удаление заметки по id

    @Query("SELECT * FROM Note")
    suspend fun getAllNotes(): List<NoteEntity> // получение всех заметок

    @Query("SELECT * FROM Note WHERE id == :id LIMIT 1")
    suspend fun getScheduledNoteById(id: Int): NoteEntity // получение заметки по id
}