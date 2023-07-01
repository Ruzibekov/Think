package com.ruzibekov.think.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ruzibekov.think.ui.screens.main.components.MainContentView
import com.ruzibekov.think.ui.screens.main.components.MainFloatingActionButtonView
import com.ruzibekov.think.ui.screens.main.components.MainTopBarView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState

object MainScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        Scaffold(
            topBar = {
                MainTopBarView.Default(state)
            },
            floatingActionButton = {
                MainFloatingActionButtonView.Default(listeners)
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                MainContentView.Default(state, listeners)
            }
        }
    }
    
}