package com.example.test_learn.ui.NavGraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.test_learn.ui.components.TreeHome
import com.example.test_learn.ui.screens.CardList
import com.example.test_learn.ui.screens.Snapbar
import com.example.test_learn.ui.screens.shopingCard
import com.example.test_learn.ui.task2.StateApp

@Composable
fun NavHostData(modifier: Modifier = Modifier, navController: NavHostController,padding:PaddingValues) {

    NavHost(navController = navController , startDestination = "home",
        modifier = Modifier.padding(padding)) {
        composable(route = "home"){
            TreeHome()
        }
        composable(route="snapbar"){
            Snapbar()
        }
        composable(route = "stateapp"){
            StateApp()
        }
        composable(route="shoping"){
            shopingCard()
        }
        composable(route = "loadimages"){
            CardList()
        }

    }
}