package com.hfad.notesapp.adapter

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.Note
import com.hfad.notesapp.R

class NoteViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(note: Note) {
        view.findViewById<TextView>(R.id.title_note).text = note.title
        view.findViewById<TextView>(R.id.message_text_note).text = note.message

        view.findViewById<TextView>(R.id.title_note).setOnClickListener {
            Toast.makeText(view.context, note.title, Toast.LENGTH_SHORT).show()
        }
    }
}