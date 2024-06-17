package com.hfad.notesapp.adapter

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.Note
import com.hfad.notesapp.databinding.ItemNoteBinding
import com.hfad.notesapp.utils.toSimpleText
import java.time.LocalDate

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
            maxLines = 2
            setOnClickListener {
                maxLines = if (maxLines == 2) {
                    Int.MAX_VALUE
                } else {
                    2
                }
            }
        }
    }
}