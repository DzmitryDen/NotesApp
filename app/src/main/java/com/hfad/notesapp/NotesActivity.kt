package com.hfad.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.adapter.NoteAdapter

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val navigationButtonLogout = findViewById<TextView>(R.id.logout)
        navigationButtonLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val navigationButtonAddNew = findViewById<TextView>(R.id.add_new)
        navigationButtonAddNew.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        findViewById<RecyclerView>(R.id.recycler_notes).run {
            layoutManager = LinearLayoutManager(this@NotesActivity)
            adapter = NoteAdapter().apply {
                submitList(NoteDataBase.noteList)
            }
        }
    }
}