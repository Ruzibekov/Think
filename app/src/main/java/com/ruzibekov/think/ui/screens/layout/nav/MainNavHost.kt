package com.ruzibekov.think.ui.screens.layout.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.MAIN.route){

    }
}

enum class Screen(val route: String){
    MAIN("main-route"), DETAILS("details-route")
}