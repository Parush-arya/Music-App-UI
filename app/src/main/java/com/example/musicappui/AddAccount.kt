package com.example.musicappui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun AddAccount(show: MutableState<Boolean>) {
    var email = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    if (show.value == true)
        Dialog(
            onDismissRequest = { show.value = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Add Account", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                TextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    Modifier.background(color = Color.White, shape = RoundedCornerShape(32.dp))
                )
                TextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    Modifier.background(color = Color.White, shape = RoundedCornerShape(32.dp))
                )
                Row() {
                    Button(onClick = { show.value = false }) {
                        Text(text = "Submit")
                    }

                    Button(onClick = { show.value = false }) {
                        Text(text = "Dismiss")
                    }
                }
            }

        }
}