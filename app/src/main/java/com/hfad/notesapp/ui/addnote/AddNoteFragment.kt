package com.hfad.notesapp.ui.addnote

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hfad.notesapp.R
import com.hfad.notesapp.data.Note
import com.hfad.notesapp.data.ScheduledNote
import com.hfad.notesapp.databinding.FragmentAddNoteBinding
import com.hfad.notesapp.db.NoteDataBase
import com.hfad.notesapp.ui.notes.NotesFragment
import com.hfad.notesapp.validation.checkEmpty
import com.hfad.notesapp.validation.validatorToast
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

const val DATE_FORMAT = "%02d/%02d/%04d"

@AndroidEntryPoint
class AddNoteFragment : Fragment() {

    private var binding: FragmentAddNoteBinding? = null
    private val viewModel: AddNoteViewModel by viewModels()

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

        viewModel.checkTitleEmpty(binding?.fieldTitle, context)
        viewModel.checkMessageEmpty(binding?.fieldMessage, context)

        binding?.dateCheckBox?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                binding?.fieldDate?.setOnClickListener {
                    val calendar = Calendar.getInstance()
                    val day = calendar.get(Calendar.DAY_OF_MONTH)
                    val month = calendar.get(Calendar.MONTH)
                    val year = calendar.get(Calendar.YEAR)

                    val datePickerDialog = context?.let { it1 ->
                        DatePickerDialog(
                            it1,
                            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->

                                binding?.fieldDate?.setText(
                                    String.format(
                                        DATE_FORMAT,
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

                binding?.addButton?.setOnClickListener {
                    if (!viewModel.blocker1 && !viewModel.blocker2) {

                        viewModel.addScheduledNote(binding?.fieldTitle, binding?.fieldMessage, binding?.fieldDate)

//                        NoteDataBase().noteList.add(
//                            ScheduledNote(
//                                binding?.fieldTitle?.text.toString(),
//                                binding?.fieldMessage?.text.toString(),
//                                binding?.fieldDate?.text.toString()
//                            )
//                        )

                        parentFragmentManager.beginTransaction()
                            .replace(R.id.container, NotesFragment())
                            .addToBackStack(null)
                            .commit()
                    }
                }
            }
        }

        binding?.addButton?.setOnClickListener {

            if (!viewModel.blocker1 && !viewModel.blocker2) {

                viewModel.addNote(binding?.fieldTitle, binding?.fieldMessage)

//                NoteDataBase().noteList.add(
//                    Note(
//                        binding?.fieldTitle?.text.toString(),
//                        binding?.fieldMessage?.text.toString()
//                    )
//                )

                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, NotesFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

    }
}