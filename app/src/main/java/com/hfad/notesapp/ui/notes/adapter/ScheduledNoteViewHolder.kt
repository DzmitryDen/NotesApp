package com.hfad.notesapp.ui.notes.adapter

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hfad.notesapp.data.ScheduledNote
import com.hfad.notesapp.databinding.ItemScheduledNoteBinding
import com.hfad.notesapp.utils.compareDates
import com.hfad.notesapp.utils.toSimpleText
import java.time.LocalDate

class ScheduledNoteViewHolder(private val binding: ItemScheduledNoteBinding) :
    ViewHolder(binding.root) {

    private val titleView = binding.titleScheduledNote
    private val messageView = binding.messageTextScheduledNote
    private val dateView = binding.dateScheduledNote
    private val item = binding.root

    fun bind(note: ScheduledNote) {
        titleView.text = note.title
        messageView.text = note.message
        dateView.text = note.date

        if (compareDates(note.date, LocalDate.now().toSimpleText()) == 0) {
            item.setBackgroundColor(Color.YELLOW)
        }

        if (compareDates(note.date, LocalDate.now().toSimpleText()) == 1) {
            item.setBackgroundColor(Color.RED)
        }

        if (compareDates(note.date, LocalDate.now().toSimpleText()) == 2) {
            item.setBackgroundColor(Color.GREEN)
        }
    }
}