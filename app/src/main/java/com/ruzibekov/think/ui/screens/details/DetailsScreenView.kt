package com.ruzibekov.think.ui.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.ui.screens.components.base.BaseNoteDetailsScreenView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState

object DetailsScreenView {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        state.selectedNote.value?.let { note ->
            BaseNoteDetailsScreenView.Default(
                state = state,
                listeners = listeners,
                onDone = {
                    listeners.updateNote(
                        NoteData(
                            id = note.id,
                            color = note.color,
                            title = state.noteEditTitle.value,
                            description = state.noteEditDesc.value,
                            category = state.noteEditCategory.value
                        )
                    )
                },
                onDeleteButton = true,
                saveButtonIsActive = remember { mutableStateOf(false) }
            )
        }
    }

    @Composable
    fun Preview() {
        val state = MainState()
        val listeners = object : MainListeners {
            override fun openNoteDetails(note: NoteData) {}
            override fun openNewNoteScreen() {}
            override fun createNewNote(noteData: NoteData) {}
            override fun updateNote(noteData: NoteData) {}
            override fun onBackStack() {}
            override fun showCategoryChangeDialog() {}
            override fun showWarningCancelChangeDialog() {}
            override fun showDeletionWarningDialog() {}
            override fun deleteNote(note: NoteData) {}
        }
        Default(state, listeners)
    }
}