package com.example.test_learn.ui.task2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_learn.ui.theme.Test_LearnTheme

@Composable
fun StateApp(modifier: Modifier = Modifier) {
    Test_LearnTheme {
        val states:List<String> = remember {
            listOf(
                "Ronald",
                "Kenoly",
                "Osvaldo",
                "Yika",
                "Mentalist",
                "Noella"
            )
        }

        var guess by remember {
            mutableStateOf("")
        }

        var guessedState: String? by remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            EnterGuess(
                modifier = Modifier.padding(12.dp),
                guess = guess,
                guessChanged = {
                    newGuess->
                    guess = newGuess
                },
                checkGuess = {
                    guessedState = states.find { it == guess }

                }
            )
            
            Spacer(modifier = modifier.height(24.dp))
            DisplayStates (states = states , guessedState = guessedState.toString())

        }
    }
    
}


@Composable
fun EnterGuess(modifier: Modifier = Modifier
,guess:String,
               guessChanged:(String)-> Unit,
               checkGuess:()-> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()
        .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = guess, onValueChange = guessChanged
//            code the logic here
        , placeholder = {
            Text(text = "Enter Name")
        })
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = checkGuess


        ) {
            Text(text = "make your guess",
                style = MaterialTheme.typography.titleLarge)

        }

    }
}


@Composable
fun DisplayStates(modifier: Modifier = Modifier,
                  states:List<String>,
                  guessedState:String
) {
    LazyVerticalGrid(modifier=Modifier,
        columns = GridCells.Adaptive(minSize = 120.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(states){
            item ->
            val isSelected = guessedState == item
            val borderColor = if(isSelected)MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onSecondaryContainer
            
            Box(modifier = Modifier
                .height(120.dp)
                .background(MaterialTheme.colorScheme.surfaceBright)
                .border(
                    width = 10.dp,
                    color = borderColor
                ),

                )
        }
    }
    
}

@Preview
@Composable
private fun StateApppreview() {
    StateApp()

}