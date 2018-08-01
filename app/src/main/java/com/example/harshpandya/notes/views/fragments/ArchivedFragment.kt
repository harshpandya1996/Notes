package com.example.harshpandya.notes.views.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.harshpandya.notes.R

class ArchivedFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_archived, container, false)

        getLayouts()

        return mView

    }

    private fun getLayouts() {
        mRecyclerView = mView.findViewById(R.id.recycler_view_archived_notes)
    }
}
