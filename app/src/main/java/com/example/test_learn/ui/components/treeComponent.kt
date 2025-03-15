package com.example.test_learn.ui.components

import android.content.res.Resources
import android.support.v4.os.IResultReceiver.Default
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_learn.R

@Composable
fun TreeHome() {
    Box(modifier = Modifier.fillMaxSize(1f)){
        Image(painter = painterResource(id = R.drawable.tree), contentDescription = "tree background" , contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize(1f))
        Column(modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text(text = stringResource(id = R.string.app_name),modifier = Modifier,
                colorResource(id = R.color.teal_700), fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.End
            )
        }

    }

}

@Preview
@Composable
private fun TreeHomePreview() {
    TreeHome()

}