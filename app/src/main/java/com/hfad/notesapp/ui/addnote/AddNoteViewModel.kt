package com.hfad.notesapp.ui.addnote

import android.content.Context
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModel
import com.hfad.notesapp.R
import com.hfad.notesapp.repositories.NoteRepository
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val noteRepository: NoteRepository) :
    ViewModel() {

    var blocker1: Boolean = true
    var blocker2: Boolean = true

//    private val noteRepository = NoteRepository()

    fun addScheduledNote(title: EditText?, message: EditText?, date: EditText?) {
        noteRepository.addScheduledNote(title, message, date)
    }

    fun addNote(title: EditText?, message: EditText?) {
        noteRepository.addNote(title, message)
    }

    fun checkTitleEmpty(field: EditText?, context: Context?) {
        field?.doAfterTextChanged { text ->
            if (context != null) {
                validatorToast(
                    context,
                    checkEmpty(text),
                    context.getString(R.string.error_not_empty)
                )
            }

            if (!checkEmpty(text)) {
                blocker1 = false
            }
        }
    }

    fun checkMessageEmpty(field: EditText?, context: Context?) {
        field?.doAfterTextChanged { text ->
            if (context != null) {
                validatorToast(
                    context,
                    checkEmpty(text),
                    context.getString(R.string.error_not_empty)
                )
            }

            if (!checkEmpty(text)) {
                blocker2 = false
            }
        }
    }
}