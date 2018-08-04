package com.example.harshpandya.notes.views.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.harshpandya.notes.R
import com.example.harshpandya.notes.adapters.NotesAdapter
import com.example.harshpandya.notes.models.Note
import com.example.harshpandya.notes.utils.NotesAsyncTask

class AllNotesFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mNotesAdapter: NotesAdapter
    private lateinit var mNotesList: ArrayList<Note>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_all_notes, container, false)

        getDatafromDb()

        getLayouts()

        return mView
    }


    private fun getDatafromDb() {
        NotesAsyncTask("retrieve",null,activity.baseContext).execute().get()
        mNotesList = NotesAsyncTask.ALL_NOTES as ArrayList<Note>
    }

    private fun getLayouts() {
        mRecyclerView = mView.findViewById(R.id.recycler_view_all_notes)
        setAdapter()
    }

    private fun setAdapter() {

        mNotesAdapter = NotesAdapter(mNotesList)

        mRecyclerView.apply {
            setHasFixedSize(false)
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            adapter = mNotesAdapter
        }

    }

}
