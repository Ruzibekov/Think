package com.ruzibekov.think.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ruzibekov.think.ui.screens.details.DetailsScreenView
import com.ruzibekov.think.ui.screens.main.MainScreenView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.screens.new_note.NewNoteScreenView
import com.ruzibekov.think.ui.state.MainState


@Composable
fun MainNavHost(navController: NavHostController, state: MainState, listeners: MainListeners) {
    NavHost(
        navController = navController,
        startDestination = Screen.MAIN.route
    ) {
        composable(Screen.MAIN.route) {
            MainScreenView.Default(state, listeners)
        }

        composable(Screen.DETAILS.route) {
            DetailsScreenView.Default(state = state, listeners)
        }

        composable(Screen.NEW_NOTE.route) {
            NewNoteScreenView.Default(listeners = listeners)
        }
    }
}

enum class Screen(val route: String) {
    MAIN("main-route"), DETAILS("details-route"), NEW_NOTE("new-note-route")
}