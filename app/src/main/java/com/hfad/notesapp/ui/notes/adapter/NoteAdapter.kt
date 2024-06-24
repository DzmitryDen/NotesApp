package com.hfad.notesapp.ui.notes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hfad.notesapp.data.Note
import com.hfad.notesapp.data.ScheduledNote
import com.hfad.notesapp.databinding.ItemNoteBinding
import com.hfad.notesapp.databinding.ItemScheduledNoteBinding

class NoteAdapter : ListAdapter<Any, ViewHolder>(object : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {

            NOTE -> NoteViewHolder(
                ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            SCHEDULED_NOTE -> ScheduledNoteViewHolder(
                ItemScheduledNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            else -> {
                val view = View(parent.context)
                val recyclerView = object : ViewHolder(view) {}
                recyclerView
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {

            is NoteViewHolder -> {
                (getItem(position) as? Note)?.let {
                    holder.bind(it)
                }
            }

            is ScheduledNoteViewHolder -> {
                (getItem(position) as? ScheduledNote)?.let {
                    holder.bind(it)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Note -> NOTE
            is ScheduledNote -> SCHEDULED_NOTE
            else -> NOTFIND
        }
    }
}

private const val NOTE = 1
private const val SCHEDULED_NOTE = 2
private const val NOTFIND = 0
