package com.example.harshpandya.notes.views.fragments

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.harshpandya.notes.R
import com.example.harshpandya.notes.database.NoteDatabase
import com.example.harshpandya.notes.models.Note

class AddNoteFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mTitle: EditText
    private lateinit var mContent: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_add_note, container, false)

        getLayouts()

        return mView
    }

    private fun getLayouts() {

        mTitle = mView.findViewById(R.id.title_add_note)
        mContent = mView.findViewById(R.id.content_add_note)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDetach() {
        val note = Note()
        note.titles = mTitle.text.toString()
        note.note = mContent.text.toString()
        note.created_date = java.time.LocalDateTime.now().toString()
        note.modified_date = java.time.LocalDateTime.now().toString()
        NoteDatabase.DB_INSTANCE!!.getNoteDao().addNote(note)
        super.onDetach()
    }

}
