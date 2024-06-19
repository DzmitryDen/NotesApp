package com.hfad.notesapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.hfad.notesapp.databinding.FragmentAddNoteBinding
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast
import java.util.Calendar

class AddNoteFragment : Fragment() {

    private var binding: FragmentAddNoteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigationButtonBack = binding?.back
        navigationButtonBack?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesFragment())
                .addToBackStack(null)
                .commit()
        }

        val titleField = binding?.fieldTitle
        val messageField = binding?.fieldMessage
        val addButton = binding?.addButton
        val checkBox = binding?.dateCheckBox
        val dateField = binding?.fieldDate


        var blocker1: Boolean = true
        var blocker2: Boolean = true

        titleField?.doAfterTextChanged { text ->
            validatorToast(context, checkEmpty(text), getString(R.string.error_not_empty))
            if (!checkEmpty(text)) {
                blocker1 = false
            }
        }

        messageField?.doAfterTextChanged { text ->
            validatorToast(context, checkEmpty(text), getString(R.string.error_not_empty))
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

                    val datePickerDialog = context?.let { it1 ->
                        DatePickerDialog(
                            it1,
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
                    }

                    datePickerDialog?.show()
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

                        parentFragmentManager.beginTransaction()
                            .replace(R.id.container, NotesFragment())
                            .addToBackStack(null)
                            .commit()
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

                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, NotesFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

    }
}