package com.example.notes.data

import androidx.room.*
import com.example.notes.model.NoteModel
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {
    @Query(value = "SELECT * from notes_tbl")
    fun getAllNotes(): Flow<List<NoteModel>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend  fun insertNote(note: NoteModel)


    @Query(value = "SELECT * from notes_tbl where id = :id")
    suspend   fun getNoteById(id: String): NoteModel



//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun update(note: NoteModel): NoteModel



    @Query("DELETE from notes_tbl")
    suspend   fun  deleteAll()


    @Delete
    suspend fun  deleteNote(note:NoteModel)
}
