package com.example.notes.repository

import com.example.notes.data.NoteDatabaseDao
import com.example.notes.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: NoteModel) = noteDatabaseDao.insertNote(note = note)
    suspend fun removeNote(note: NoteModel) = noteDatabaseDao.deleteNote(note)
    suspend fun getNote(id: String): NoteModel = noteDatabaseDao.getNoteById(id)
    fun getAllNotes(): Flow<List<NoteModel>> = noteDatabaseDao.getAllNotes().flowOn(
        Dispatchers.IO).conflate()
    suspend fun  deleteAll() = noteDatabaseDao.deleteAll()

}