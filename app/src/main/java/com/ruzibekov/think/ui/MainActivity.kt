package com.ruzibekov.think.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ruzibekov.think.ui.nav.MainNavHost
import com.ruzibekov.think.ui.nav.Screen
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.theme.ThinkTheme

class MainActivity : ComponentActivity(), MainListeners {

    private val viewModel by viewModels<MainViewModel>()
    private var navController: NavHostController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()

            navController?.let { controller ->
                ThinkTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MainNavHost(
                            navController = controller,
                            state = viewModel.state,
                            listeners = this
                        )
                    }
                }
            }
        }
    }

    override fun openNoteDetails(index: Int) {
        viewModel.state.selectedNoteIndex.value = index
        navController?.navigate(Screen.DETAILS.route)
    }

    override fun openNewNoteScreen() {
        navController?.navigate(Screen.NEW_NOTE.route)
    }

    override fun createNewNote() {
//        TODO("Not yet implemented")
    }

    override fun addNote() {
        viewModel.addNote()
    }
}