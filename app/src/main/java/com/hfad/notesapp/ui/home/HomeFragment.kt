package com.hfad.notesapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hfad.notesapp.R
import com.hfad.notesapp.databinding.FragmentHomeBinding
import com.hfad.notesapp.ui.addnote.AddNoteFragment
import com.hfad.notesapp.ui.notes.NotesFragment

class HomeFragment: Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, NotesFragment())
            .commit()

        binding?.bottomNavigationView?.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.notes -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, NotesFragment())
                        .commit()
                    true
                }

                R.id.add -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, AddNoteFragment())
                        .commit()
                    true
                }

                R.id.search -> {
                    true
                }

                else -> false

            }
        }
    }
}