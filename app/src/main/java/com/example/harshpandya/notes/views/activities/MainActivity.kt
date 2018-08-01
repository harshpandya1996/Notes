package com.example.harshpandya.notes.views.activities

import android.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.harshpandya.notes.R
import com.example.harshpandya.notes.views.fragments.AddNoteFragment
import com.example.harshpandya.notes.views.fragments.AllNotesFragment
import com.example.harshpandya.notes.views.fragments.ArchivedFragment
import com.example.harshpandya.notes.views.fragments.PinnedFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mFragmentManager = fragmentManager

        if(savedInstanceState == null)
        {
            var mTransaction = mFragmentManager.beginTransaction()
            mTransaction.replace(R.id.main_fragment_container,AllNotesFragment())
            mTransaction.commit()
        }

        fab.setOnClickListener {
            var mTransaction = mFragmentManager.beginTransaction()
            mTransaction.replace(R.id.main_fragment_container,AddNoteFragment())
            mTransaction.commit()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_search -> return true
            R.id.action_sort -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_all_notes -> {
                var mTransaction = mFragmentManager.beginTransaction()
                mTransaction.replace(R.id.main_fragment_container,AllNotesFragment())
                mTransaction.commit()
            }
            R.id.nav_pinned_notes -> {
                var mTransaction = mFragmentManager.beginTransaction()
                mTransaction.replace(R.id.main_fragment_container,PinnedFragment())
                mTransaction.commit()
            }
            R.id.nav_archived_notes -> {
                var mTransaction = mFragmentManager.beginTransaction()
                mTransaction.replace(R.id.main_fragment_container,ArchivedFragment())
                mTransaction.commit()
            }
            R.id.nav_deleted_notes -> {
                var mTransaction = mFragmentManager.beginTransaction()
                mTransaction.replace(R.id.main_fragment_container,ArchivedFragment())
                mTransaction.commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
