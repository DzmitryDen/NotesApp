package com.hfad.notesapp.ui.notes

import androidx.lifecycle.ViewModel
import com.hfad.notesapp.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

//    private val noteRepository = NoteRepository()

    fun getNoteList(): ArrayList<Any> {
        return noteRepository.getNoteList()
    }
}