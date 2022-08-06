package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notes.screens.NoteScreen
import com.example.notes.screens.NoteViewModel
import com.example.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint




@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        MyApp {
val noteViewModel : NoteViewModel  by   viewModels()
            NoteScreenOverall(notesViewModel = noteViewModel)

        }
        }
    }
}








@Preview
@ExperimentalComposeUiApi
@Composable
fun NoteScreenOverall(notesViewModel: NoteViewModel = viewModel()){

    val notes = notesViewModel.noteList.collectAsState().value


    NoteScreen(

        onAddNote = {
                notesViewModel.addNote(it)


        },

        onRemoveNote = {
            notesViewModel.removeNote(it)

        },
        noteList =  notes,

    )
}






@Composable
fun MyApp(content: @Composable ()-> Unit){
    NotesTheme {

        content()





    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesTheme {

    }
}