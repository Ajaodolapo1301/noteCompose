package com.example.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.notes.model.NoteModel
import com.example.notes.shared.utils.UUIDConverter

@Database(entities = [NoteModel::class], version = 1, exportSchema =false )
@TypeConverters(UUIDConverter::class)
abstract class  NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDatabaseDao
}