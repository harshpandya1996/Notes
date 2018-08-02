package com.example.harshpandya.notes.utils

import android.os.AsyncTask
import com.example.harshpandya.notes.database.NoteDatabase
import com.example.harshpandya.notes.models.Note


class NotesAsyncTask(aOperation: String?,aNote: Note?) : AsyncTask<Unit,Unit,Unit>() {

    companion object {
        var ALL_NOTES: List<Note> = ArrayList<Note>()
    }

    private var mOperation = aOperation
    private var mNote = aNote

    override fun doInBackground(vararg params: Unit?) {
        if(mOperation.equals("insert"))
        {
            NoteDatabase.DB_INSTANCE!!.getNoteDao().addNote(aNote = mNote!!)
        }
        if(mOperation.equals("retrieve"))
        {
            ALL_NOTES = NoteDatabase.DB_INSTANCE!!.getNoteDao().getAllNotes() as ArrayList<Note>
        }
    }


}