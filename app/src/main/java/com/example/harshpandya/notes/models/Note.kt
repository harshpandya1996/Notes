package com.example.harshpandya.notes.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "table_note")
data class Note (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int? = null,
        @ColumnInfo(name = "title")
        var titles: String? = null,
        @ColumnInfo(name = "note")
        var note: String? = null,
        @ColumnInfo(name = "created_date")
        var created_date: String? = null,
        @ColumnInfo(name = "modified_date")
        var modified_date: String?= null,
        @ColumnInfo(name = "is_deleted")
        var isDeleted: Boolean = false,
        @ColumnInfo(name = "is_pinned")
        var isPinned: Boolean = false,
        @ColumnInfo(name = "is_archived")
        var isArchived: Boolean = false
)