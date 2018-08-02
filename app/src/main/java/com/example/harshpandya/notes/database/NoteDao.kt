package com.example.harshpandya.notes.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.harshpandya.notes.models.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(aNote : Note)

    @Query("select * from table_note order by title")
    fun getAllNotes() : List<Note>
}