package com.example.notes.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notes.R
import com.example.notes.model.NoteModel
import com.example.notes.shared.CustomAppbar
import com.example.notes.shared.CustomTextField

@ExperimentalComposeUiApi

@Composable











fun NoteScreen(noteList:List<NoteModel>,
               onAddNote: (NoteModel) -> Unit,
               onRemoveNote: (NoteModel) -> Unit, ) {
    val title = remember{
        mutableStateOf("")
    }

    val desc = remember {
        mutableStateOf("")
    }
val keyboardController = LocalSoftwareKeyboardController.current

    Column() {

        TopAppBar()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            CustomTextField(value = title.value,
                onValueChanged = {
                title.value = it
            },
                modifier = Modifier
                    .padding(4.dp)
                    .background(color = Color.Transparent)
                    .fillMaxWidth(),
                label = "Title"
            )


            CustomTextField(value = desc.value, onValueChanged = {
                desc.value = it
            },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                label = "Description")

                Box(
                    modifier = Modifier.fillMaxWidth(),
                 contentAlignment = Alignment.Center
                ) {
                    Button(

                        onClick = {

                            onAddNote(NoteModel(title = title.value, description = desc.value))
                                    title.value = ""
                                    desc.value = ""
                                keyboardController?.hide()
                        },
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                    ) {
                        Text(text = "Submit")
                    }
                }


        }


Spacer(modifier = Modifier.height(10.dp))

        LazyColumn{
            items(items = noteList){


                NoteWidget(it, onRemoveNote = {
                    onRemoveNote(it)
                }
                )
            }
        }
//        scrollList(notes = noteList, onRemoveNote = onRemoveNote)

    }


}



@Composable

fun TopAppBar(){
    CustomAppbar(
        title = stringResource(id = R.string.app_name),
        action = Icons.Default.Notifications,
        backgroundColor = Color.Magenta
    )

}


//@Composable
//fun scrollList(notes:List<NoteModel>, onRemoveNote:(NoteModel)-> Unit){
//
//}



@Composable
fun NoteWidget(noteModel: NoteModel, onRemoveNote: (NoteModel) -> Unit){
    Surface(
        modifier = Modifier
            .height(height = 80.dp)
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp)),
        color = Color.LightGray


    ) {
   Column(

       modifier = Modifier
           .clickable {
               Log.d("TAG", "NoteWidget11: $noteModel")
               onRemoveNote(noteModel)
           }
           .padding(horizontal = 6.dp, vertical = 7.dp)
   ) {
       Text(noteModel.title, style = MaterialTheme.typography.h6.copy(
           fontSize = 14.sp
       ))
       Text(noteModel.description, style = MaterialTheme.typography.h6.copy(
           fontSize = 12.sp
       ))
   }

    }
}