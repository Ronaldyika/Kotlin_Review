package com.example.test_learn.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter


@Composable
fun CardTask(modifier: Modifier = Modifier,name:String,largeUrl:String,job:String) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Box(modifier = Modifier.fillMaxWidth()){
            Image(
                painter = rememberAsyncImagePainter(largeUrl),
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
                )
        }
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "$name", modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = "$job", fontWeight = FontWeight.Medium)
            
        }
    }
    
}

@Preview
@Composable
private fun CardPreview() {
    CardTask(name = "cow photo", largeUrl = "url", job = "poetry")

}