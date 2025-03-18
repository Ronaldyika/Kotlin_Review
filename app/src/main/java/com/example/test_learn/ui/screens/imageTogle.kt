package com.example.test_learn.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_learn.R

@Composable
fun imageTogler(modifier: Modifier = Modifier) {
    var isChecked by remember {
        mutableStateOf(true)
    }
    var imageId = if(isChecked) R.drawable.tree else R.drawable.ic_launcher_background
        
    Column(modifier = Modifier.fillMaxSize(1f)) {
        Switch(checked = true, onCheckedChange = {
            isChecked = it
        })
    Image(painter = painterResource(id = imageId), contentDescription = "toggled image", modifier = Modifier.size(250.dp).padding(15.dp).clip(
        CircleShape), contentScale = ContentScale.Fit)

    }
}

@Preview
@Composable
private fun imageToglePreview() {
    imageTogler()

}