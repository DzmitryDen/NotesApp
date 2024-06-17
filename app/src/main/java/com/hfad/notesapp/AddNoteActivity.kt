package com.hfad.notesapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.hfad.notesapp.databinding.ActivityAddNoteBinding
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast
import java.util.Calendar

class AddNoteActivity : AppCompatActivity() {

    private var binding: ActivityAddNoteBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddNoteBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val navigationButtonBack = binding?.back
        navigationButtonBack?.setOnClickListener {
            onBackPressed()
        }

        val titleField = binding?.fieldTitle
        val messageField = binding?.fieldMessage
        val addButton = binding?.addButton
        val checkBox = binding?.dateCheckBox
        val dateField = binding?.fieldDate


        var blocker1: Boolean = true
        var blocker2: Boolean = true

        titleField?.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
            if (!checkEmpty(text)) {
                blocker1 = false
            }
        }

        messageField?.doAfterTextChanged { text ->
            validatorToast(this, checkEmpty(text), getString(R.string.error_not_empty))
            if (!checkEmpty(text)) {
                blocker2 = false
            }
        }

        checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                dateField?.setOnClickListener {
                    val calendar = Calendar.getInstance()
                    val day = calendar.get(Calendar.DAY_OF_MONTH)
                    val month = calendar.get(Calendar.MONTH)
                    val year = calendar.get(Calendar.YEAR)

                    val datePickerDialog = DatePickerDialog(
                        this,
                        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->

                            dateField.setText(
                                String.format(
                                    "%02d/%02d/%04d",
                                    dayOfMonth,
                                    monthOfYear + 1,
                                    year
                                )
                            )
                        },
                        year,
                        month,
                        day
                    )

                    datePickerDialog.show()
                }

                addButton?.setOnClickListener {
                    if (!blocker1 && !blocker2) {
                        NoteDataBase.noteList.add(
                            ScheduledNote(
                                titleField?.text.toString(),
                                messageField?.text.toString(),
                                dateField?.text.toString()
                            )
                        )
                        val intent = Intent(this, NotesActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }

        addButton?.setOnClickListener {
            if (!blocker1 && !blocker2) {
                NoteDataBase.noteList.add(
                    Note(
                        titleField?.text.toString(),
                        messageField?.text.toString()
                    )
                )
                val intent = Intent(this, NotesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}