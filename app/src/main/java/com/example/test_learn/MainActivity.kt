package com.example.test_learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_learn.ui.NavGraph.NavHostData
import com.example.test_learn.ui.components.TreeHome
import com.example.test_learn.ui.screens.CoilImageLoad
import com.example.test_learn.ui.screens.Snapbar
import com.example.test_learn.ui.screens.shopingCard
import com.example.test_learn.ui.task2.StateApp
import com.example.test_learn.ui.theme.Test_LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            mainBody()
        }
    }
}

@Composable
fun mainBody(modifier: Modifier = Modifier) {
    Test_LearnTheme {
        val navController = rememberNavController()
        Scaffold (
            modifier = Modifier,
            topBar =
                    {
                        MainHeadContent()
                    },
            bottomBar = {
                footerNav(navcontroller = navController)
            }

        ){
            innerPadding ->
            NavHostData(modifier=Modifier,navController=navController,innerPadding)
        }
    }
}

@Composable
fun MainHeadContent(modifier: Modifier = Modifier) {
    Row (modifier = Modifier
        .height(50.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){
        Icon(imageVector = Icons.Filled.Face, contentDescription = "main icon")
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Compose Learn")
    }

}

@Composable
fun footerNav(modifier: Modifier = Modifier.fillMaxWidth(),navcontroller: NavHostController) {
    Row (modifier = Modifier
        .padding(10.dp)
        .height(40.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = Icons.Filled.Home, contentDescription = "home btn",
            modifier = Modifier.clickable {
                navcontroller.navigate("home"){
                    popUpTo(navcontroller.graph.startDestinationId)
                    launchSingleTop =true

                }
            })
        Spacer(modifier = Modifier.padding(10.dp))
        Icon(imageVector = Icons.Filled.Build, contentDescription = "snapbar",
            modifier = Modifier.clickable {
                navcontroller.navigate("snapbar"){
                    popUpTo(navcontroller.graph.startDestinationId)
                    launchSingleTop = true
                }
            })
        Spacer(modifier = Modifier.padding(10.dp))
        Icon(imageVector = Icons.Filled.Menu, contentDescription = "stateapp",
            modifier = Modifier.clickable {
                navcontroller.navigate("stateapp"){
                    popUpTo(navcontroller.graph.startDestinationId)
                    launchSingleTop = true
                }
            })
        Spacer(modifier = Modifier.padding(10.dp))
        Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "shoping",
            modifier = Modifier.clickable {
                navcontroller.navigate("shoping"){
                    popUpTo(navcontroller.graph.startDestinationId)
                    launchSingleTop = true
                }
            })
        Spacer(modifier = Modifier.padding(10.dp))
        Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "items",
            modifier = Modifier.clickable {
                navcontroller.navigate("loadimages"){
                    popUpTo(navcontroller.graph.startDestinationId)
                    launchSingleTop = true
                }
            })

    }

}

@Preview
@Composable
private fun mainBodyPreview() {
    mainBody()

}