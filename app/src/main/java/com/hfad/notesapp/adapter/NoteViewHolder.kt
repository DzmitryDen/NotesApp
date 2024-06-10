package com.hfad.notesapp.adapter

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.Note
import com.hfad.notesapp.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NoteViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private fun getMessageDate(): String {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return currentDate.format(formatter)
    }

    fun bind(note: Note) {
        val titleView = view.findViewById<TextView>(R.id.title_note)
        val messageView = view.findViewById<TextView>(R.id.message_text_note)
        val dateView = view.findViewById<TextView>(R.id.date_note)

        titleView.text = note.title
        messageView.text = note.message
        dateView.text = getMessageDate()

        view.findViewById<TextView>(R.id.title_note).setOnClickListener {
            Toast.makeText(view.context, note.title, Toast.LENGTH_SHORT).show()
        }
    }
}