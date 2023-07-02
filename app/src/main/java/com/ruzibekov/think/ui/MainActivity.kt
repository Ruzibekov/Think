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
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.ui.nav.MainNavHost
import com.ruzibekov.think.ui.nav.Screen
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.theme.ThinkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), MainListeners {

    private val viewModel: MainViewModel by viewModels()

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
        fetchNoteList()
    }

    private fun fetchNoteList(){
        viewModel.fetchNoteList()
    }

    override fun openNoteDetails(index: Int) {
        viewModel.state.selectedNoteIndex.value = index
        navController?.navigate(Screen.DETAILS.route)
    }

    override fun openNewNoteScreen() {
        navController?.navigate(Screen.NEW_NOTE.route)
    }

    override fun createNewNote(noteData: NoteData) {
        viewModel.createNewNote(noteData)
        viewModel.fetchNoteList()
        backToMainScreen()
    }

    override fun updateNote(noteData: NoteData) {
        viewModel.updateNote(noteData)
    }

    override fun backToMainScreen() {
        navController?.popBackStack()
    }

}