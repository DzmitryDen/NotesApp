package com.hfad.notesapp.ui.notes.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hfad.notesapp.data.Note

class NoteDiffUtil : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}