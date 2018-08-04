package com.example.harshpandya.notes.utils

import android.content.Context
import android.os.AsyncTask
import com.example.harshpandya.notes.database.NoteDatabase
import com.example.harshpandya.notes.models.Note


class NotesAsyncTask(aOperation: String?,aNote: Note?,aContext: Context) : AsyncTask<Unit,Unit,Unit>() {

    companion object {
        var ALL_NOTES: List<Note> = ArrayList<Note>()
    }

    private var mOperation = aOperation
    private var mNote = aNote
    private var mContext = aContext

    override fun doInBackground(vararg params: Unit?) {
        if(mOperation.equals("insert"))
        {
            NoteDatabase.getDbInstance(mContext)!!.getNoteDao().addNote(aNote = mNote!!)
        }
        if(mOperation.equals("retrieve"))
        {
            ALL_NOTES = NoteDatabase.getDbInstance(mContext)!!.getNoteDao().getAllNotes() as ArrayList<Note>
        }
    }


}