package com.example.test_learn.ui.screens

import android.content.ContentValues.TAG
import android.graphics.drawable.shapes.Shape
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.test_learn.R

@Composable
fun Snapbar(modifier: Modifier = Modifier) {
    var username: String by rememberSaveable {
        mutableStateOf("")
    }


    var useremail:String by rememberSaveable {
        mutableStateOf("")
    }
    var context = LocalContext.current

    var message:String = stringResource(
        id=R.string.message,
        username,
        useremail
    )
    Column (modifier = Modifier.fillMaxSize(1f)){
        Text(text = stringResource(id = R.string.app_name), modifier = Modifier
            .fillMaxWidth(1f)
            .padding(8.dp), textAlign = TextAlign.Center, fontFamily = FontFamily.Default
        , textDecoration = TextDecoration.None, fontSize = TextUnit.Unspecified)
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(modifier = Modifier
            .fillMaxWidth(1f)
            .padding(12.dp),value = username, onValueChange = {
            username = it
        },
            leadingIcon = {
                Icons.Default.Person
            },
            placeholder = {
                Text(text = "enter user name")
            },
            label = {
                Text(text = "User Name")
            },
            shape = RoundedCornerShape(18.dp))
        Spacer(modifier = Modifier.padding(4.dp))
        TextField(modifier = Modifier
            .fillMaxWidth(1f)
            .padding(12.dp),value = useremail, onValueChange = {
            useremail = it
        },
            placeholder = {
                Text(text = "enter a valid email")
            },
            label = {
                Text(text = "Email")
            },
            keyboardActions = KeyboardActions(

            ),
            leadingIcon = {
                Icons.Default.Email
            },
            shape = RoundedCornerShape(18.dp)
        )
        Spacer(modifier = Modifier.padding(12.dp))

        TextButton(modifier = Modifier
            .fillMaxWidth(1f)
            .padding(30.dp), shape = RoundedCornerShape(50.dp),colors = ButtonDefaults.buttonColors(),onClick = {
            Log.i(TAG, "Snapbar: ${message}")
            Toast.makeText(context,"${message}",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Register")
        }
    }
    
}

@Preview(showBackground = true)
@Composable
private fun Snapbarpreview() {
    Snapbar()

}