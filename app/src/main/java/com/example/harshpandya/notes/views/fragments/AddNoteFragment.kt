package com.example.harshpandya.notes.views.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.harshpandya.notes.R
import com.example.harshpandya.notes.models.Note
import com.example.harshpandya.notes.utils.NotesAsyncTask
import java.text.DateFormat

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

    override fun onDetach() {
        val note = Note(null,mTitle.text.toString(),mContent.text.toString(), DateFormat.getDateTimeInstance().toString(),DateFormat.getDateTimeInstance().toString())
        NotesAsyncTask("insert",note,activity.baseContext).execute().get()
        super.onDetach()
    }

}
