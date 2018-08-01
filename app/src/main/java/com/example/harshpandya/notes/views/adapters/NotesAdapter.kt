package com.example.harshpandya.notes.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        var inflater = LayoutInflater.from(parent.context).inflate(R.layout.content_one_note,parent,false)
        return NotesViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class NotesViewHolder(aView: View) : RecyclerView.ViewHolder(aView) {

    }
}