
package com.example.notes.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CustomAppbar(
    title:String?,
    elevation: Dp = 0.dp,
    showbackButton:Boolean = false,
    backgroundColor: Color =  Color.Transparent,
    action : ImageVector?,
    backButton: ()-> Unit? = {}
) {


    TopAppBar(title = {
        Text(text = title ?: "")
    }, actions = {
        if(action != null){
                    Icon(imageVector = action, contentDescription = action.toString())
                }
    },
    backgroundColor = backgroundColor

    )
//    TopAppBar(
//        elevation = elevation,
//
//
//        backgroundColor =  backgroundColor,
//
//
//
//    ) {
//            Row(
//               modifier = Modifier
//                   .fillMaxWidth()
//                   .padding(4.dp)
//                ,
//                horizontalArrangement = Arrangement.SpaceBetween) {
//                if (showbackButton){
//                    Icon(
//
//
//                        imageVector = Icons.Default.ArrowBack, contentDescription = "back button", modifier = Modifier.clickable {
//                            backButton()
//                        })
//                }
//
//                Text(text = title ?: "")
//
//                if(action != null){
//                    Icon(imageVector = action, contentDescription = action.toString())
//                }
//
//            }
//    }
}