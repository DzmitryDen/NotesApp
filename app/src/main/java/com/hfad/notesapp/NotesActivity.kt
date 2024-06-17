package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.notesapp.adapter.NoteAdapter
import com.hfad.notesapp.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {

    private var binding: ActivityNotesBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotesBinding.inflate(layoutInflater).also { setContentView(it.root) }
//        setContentView(R.layout.activity_notes)

        val navigationButtonLogout = binding?.logout
        navigationButtonLogout?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val navigationButtonAddNew = binding?.addNew
        navigationButtonAddNew?.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        setList()
    }

    private fun setList() {
        binding?.recyclerNotes?.run {
            layoutManager = LinearLayoutManager(this@NotesActivity)
            adapter = NoteAdapter().apply {
                submitList(NoteDataBase.noteList)
            }
        }
    }
}