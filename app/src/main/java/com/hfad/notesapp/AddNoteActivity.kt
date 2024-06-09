package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast

class AddNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val navigationButtonBack = findViewById<TextView>(R.id.back)
        navigationButtonBack.setOnClickListener {
            onBackPressed()
        }

        val titleField = findViewById<EditText>(R.id.field_title)
        val messageField = findViewById<EditText>(R.id.field_message)
        val addButton = findViewById<Button>(R.id.add_button)

        var blocker1: Boolean = true
        var blocker2: Boolean = true

        titleField.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
            if (!checkEmpty(text)) {
                blocker1 = false
            }
        }

        messageField.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
            if (!checkEmpty(text)) {
                blocker2 = false
            }
        }


        addButton.setOnClickListener {
            if (!blocker1 && !blocker2) {
                NoteDataBase.noteList.add(Note(titleField.text.toString(),messageField.text.toString()))
                val intent = Intent(this, NotesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}