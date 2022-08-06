package com.example.notes.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.NoteModel
import com.example.notes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository): ViewModel() {

    private val _noteList = MutableStateFlow<List<NoteModel>>(emptyList())

    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect{
                    listOfNotes ->
                    if(listOfNotes.isNullOrEmpty()){
                        Log.d("TAG", "Empty List: ")
                    }else{
                        _noteList.value = listOfNotes
                    }
                }
        }
    }
//   private var noteList = mutableStateListOf<NoteModel>()

    fun addNote(note: NoteModel) = viewModelScope.launch {
            repository.addNote(note)
    }


      fun removeNote(note: NoteModel) = viewModelScope.launch  {
        repository.removeNote(note)
    }


      fun deleteAll() = viewModelScope.launch  {
        repository.deleteAll()
    }
}