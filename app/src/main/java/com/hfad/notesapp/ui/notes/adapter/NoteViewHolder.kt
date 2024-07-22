package com.hfad.notesapp.ui.notes.adapter

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.data.Note
import com.hfad.notesapp.databinding.ItemNoteBinding
import com.hfad.notesapp.utils.toSimpleText
import java.time.LocalDate

const val MAX_LINES = 2

class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    private val titleView = binding.titleNote
    private val messageView = binding.messageTextNote
    private val dateView = binding.dateNote

    private fun getMessageDate(): String {
        return LocalDate.now().toSimpleText()
    }

    fun bind(note: Note) {
        titleView.text = note.title
        messageView.text = note.message
        dateView.text = getMessageDate()

        titleView.setOnClickListener {
            Toast.makeText(it.context, note.title, Toast.LENGTH_SHORT).show()
        }

        messageView.apply {
            maxLines = MAX_LINES
            setOnClickListener {
                maxLines = if (maxLines == MAX_LINES) {
                    Int.MAX_VALUE
                } else {
                    MAX_LINES
                }
            }
        }
    }
}