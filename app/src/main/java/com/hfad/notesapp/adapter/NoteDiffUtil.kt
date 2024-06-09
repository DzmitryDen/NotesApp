package com.hfad.notesapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hfad.notesapp.Note

class NoteDiffUtil : DiffUtil.ItemCallback<Note>() {

    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}