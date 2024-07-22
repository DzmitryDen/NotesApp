package com.hfad.notesapp.db

import android.widget.EditText
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScheduledNote")
data class ScheduledNoteEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("message")
    val message: String,
    @ColumnInfo("date")
    val date: String
)
