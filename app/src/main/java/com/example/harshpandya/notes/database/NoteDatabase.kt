package com.example.harshpandya.notes.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.harshpandya.notes.models.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    companion object {
        var DB_INSTANCE: NoteDatabase? = null

        fun getDbInstance(aContext: Context): NoteDatabase? {
            if(DB_INSTANCE == null)
            {
                DB_INSTANCE = Room.databaseBuilder(aContext,NoteDatabase::class.java,"NotesDB").build()
            }
            return DB_INSTANCE
        }
    }

    abstract fun getNoteDao(): NoteDao

}