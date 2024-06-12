package com.hfad.notesapp.adapter

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.Note
import com.hfad.notesapp.R
import com.hfad.notesapp.utils.toSimpleText
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NoteViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val titleView = view.findViewById<TextView>(R.id.title_note)
    private val messageView = view.findViewById<TextView>(R.id.message_text_note)
    private val dateView = view.findViewById<TextView>(R.id.date_note)

    private fun getMessageDate(): String {
      return LocalDate.now().toSimpleText()
    }

    fun bind(note: Note) {
        titleView.text = note.title
        messageView.text = note.message
        dateView.text = getMessageDate()

        view.findViewById<TextView>(R.id.title_note).setOnClickListener {
            Toast.makeText(view.context, note.title, Toast.LENGTH_SHORT).show()
        }

        messageView.apply {
            maxLines = 2
            setOnClickListener {
                if (maxLines == 2) {
                    maxLines = Int.MAX_VALUE
                } else {
                    maxLines = 2
                }
            }
        }
    }
}