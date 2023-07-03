package com.ruzibekov.think.ui.screens.details

import androidx.compose.runtime.Composable
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.ui.screens.components.BaseNoteDetailsScreenView
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
                }
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
            override fun backToMainScreen() {}
            override fun showCategoryChangeDialog() {}
            override fun deleteNote(note: NoteData) {}
        }
        Default(state, listeners)
    }
}