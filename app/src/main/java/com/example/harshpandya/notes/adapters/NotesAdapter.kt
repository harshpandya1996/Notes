package com.example.harshpandya.notes.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.harshpandya.notes.R
import com.example.harshpandya.notes.models.Note

class NotesAdapter(aNotesList : ArrayList<Note>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    private var mNotesList = aNotesList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        var inflater = LayoutInflater.from(parent.context).inflate(R.layout.note_one_row,parent,false)
        return NotesViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return mNotesList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        holder.titles.text = mNotesList[position].titles
        holder.content.text = mNotesList[position].note

    }

    inner class NotesViewHolder(aView: View) : RecyclerView.ViewHolder(aView) {

        var titles = aView.findViewById<TextView>(R.id.title_note_one_row)
        var content = aView.findViewById<TextView>(R.id.content_note_one_row)

    }
}