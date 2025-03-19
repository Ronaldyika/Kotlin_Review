package com.example.test_learn.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.test_learn.R
import com.example.test_learn.ViewModel.Task3ViewModel
import com.example.test_learn.ViewModel.imageId

@Composable
fun shopingCard(modifier: Modifier = Modifier) {

    val viewModel = viewModel<Task3ViewModel>()
    val quantity = viewModel.quantity.collectAsStateWithLifecycle()
    val total_amount = viewModel.totol_amount.collectAsStateWithLifecycle()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier){
            Image(painter = painterResource(id = imageId), contentDescription = "shoping image",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.Center),
                contentScale = ContentScale.Fit,
                )
            Column (modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.End){
                IconButton(onClick = { viewModel.increaseQauntity()}, colors = IconButtonColors(containerColor = Color.Green, contentColor = Color.White, disabledContentColor = Color.Black, disabledContainerColor = Color.DarkGray)) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "increment")
                }
                Spacer(modifier = Modifier.height(8.dp))

                IconButton(onClick = { viewModel.dicreaseQauntity()}, colors = IconButtonColors(containerColor = Color.Green, contentColor = Color.White, disabledContentColor = Color.Black, disabledContainerColor = Color.DarkGray)) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "decrement")
                }

            }




        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "quantity: ${quantity.value}")
        Text(text = "Price clicked: ${total_amount.value}")
        
        
        Spacer(modifier = Modifier.height(14.dp))
        
        Button(onClick = {
            viewModel.checkout()

        }) {
            Text(text = "check price")
        }


    }

}


@Preview
@Composable
private fun cardpreview() {

    shopingCard()

}