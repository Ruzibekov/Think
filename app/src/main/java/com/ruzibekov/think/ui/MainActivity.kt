package com.ruzibekov.think.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ruzibekov.domain.model.NoteCategory
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.R
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

    override fun openNoteDetails(note: NoteData) {
        viewModel.state.selectedNote.value = note
        viewModel.state.changeEditNoteData(note.title, note.description, note.category)
        navController?.navigate(Screen.DETAILS.route)
    }

    override fun openNewNoteScreen() {
        viewModel.state.changeEditNoteData("", "", NoteCategory.IDEA)
        navController?.navigate(Screen.NEW_NOTE.route)
    }

    override fun createNewNote(noteData: NoteData) {
        viewModel.createNewNote(noteData){
            viewModel.fetchNoteList()
            onBackStack()
            showToast(textRes = R.string.toast_note_created)
        }
    }

    override fun updateNote(noteData: NoteData) {
        viewModel.updateNote(noteData){
            viewModel.fetchNoteList()
            showToast(textRes = R.string.toast_changes_saved)
        }
    }

    override fun onBackStack() {
        viewModel.state.isActiveSaveButton.value = false
        navController?.popBackStack()
    }

    override fun showCategoryChangeDialog() {
        viewModel.state.showCategoryChangeDialog.value = true
    }

    override fun showWarningCancelChangeDialog() {
        viewModel.state.showWarningChangesInvalidDialog.value = true
    }

    override fun showDeletionWarningDialog() {
        viewModel.state.showDeletionWarningDialog.value = true
    }

    override fun deleteNote(note: NoteData) {
        viewModel.deleteNote(note){
            viewModel.fetchNoteList()
            onBackStack()
        }
    }

    private fun showToast(textRes: Int){
        Toast.makeText(this, getString(textRes), Toast.LENGTH_LONG).show()
    }

}