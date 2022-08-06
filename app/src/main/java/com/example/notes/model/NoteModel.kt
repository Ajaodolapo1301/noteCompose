package com.example.notes.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.*
import java.util.UUID.randomUUID

@Entity(tableName = "notes_tbl")
data class NoteModel(
    @PrimaryKey
    val id : UUID = randomUUID(),
    @ColumnInfo(name = "note_title")
    val title :String,
    @ColumnInfo(name = "note_desc")
    val description :String,
//    val date: Date = Date.from(Instant.now())
)

