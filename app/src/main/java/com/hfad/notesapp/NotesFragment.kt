package com.hfad.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.notesapp.adapter.NoteAdapter
import com.hfad.notesapp.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private var binding: FragmentNotesBinding? = null

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
                submitList(NoteDataBase.noteList)
            }
        }
    }
}