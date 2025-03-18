package com.example.test_learn.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun CoilImageLoad(modifier: Modifier = Modifier) {
    var image1 = "https://bit.ly/android_dev_image1"
    var image2 = "https://bit.ly/android_dev_image2"

    var checked by remember {
        mutableStateOf(true)
    }
    var imageId = if(checked) image1 else image2

    Column(modifier=Modifier.fillMaxSize(1f)) {
        Switch(checked = true, onCheckedChange ={
            checked = it
        } )

        AsyncImage(
            model = imageId,
            contentDescription = "togle robots",
            modifier = Modifier.size(250.dp)
        )

    }
}

@Preview
@Composable
private fun coilImagePreview() {
    CoilImageLoad()
}