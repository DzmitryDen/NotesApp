package com.hfad.notesapp.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.notesapp.R
import com.hfad.notesapp.ui.notes.adapter.NoteAdapter
import com.hfad.notesapp.databinding.FragmentNotesBinding
import com.hfad.notesapp.db.NoteDataBase
import com.hfad.notesapp.ui.addnote.AddNoteFragment
import com.hfad.notesapp.ui.login.LoginFragment

class NotesFragment : Fragment() {

    private var binding: FragmentNotesBinding? = null
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigationButtonLogout = binding?.logout
        navigationButtonLogout?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }

        val navigationButtonAddNew = binding?.addNew
        navigationButtonAddNew?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddNoteFragment())
                .addToBackStack(null)
                .commit()
        }

        setList()
    }

    private fun setList() {
        binding?.recyclerNotes?.run {
            layoutManager = LinearLayoutManager(context)
            adapter = NoteAdapter().apply {
                submitList(viewModel.getNoteList())
            }
        }
    }
}