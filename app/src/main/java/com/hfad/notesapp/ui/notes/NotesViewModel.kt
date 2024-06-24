package com.hfad.notesapp.ui.notes

import androidx.lifecycle.ViewModel
import com.hfad.notesapp.repositories.NoteRepository

class NotesViewModel : ViewModel() {

    private val noteRepository = NoteRepository()

    fun getNoteList(): ArrayList<Any> {
        return noteRepository.getNoteList()
    }
}