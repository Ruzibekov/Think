package com.ruzibekov.think.ui.screens.details

import androidx.compose.runtime.Composable
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.ui.screens.base.BaseNoteDetailsScreenView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState

object DetailsScreenView {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        val note = state.noteList[state.selectedNoteIndex.value]

        BaseNoteDetailsScreenView.Default(
            defTitle = note.title,
            defDescription = note.description,
            listeners = listeners
        ) { title, description ->
            listeners.updateNote(
                NoteData(
                    id = note.id,
                    color = note.color,
                    title = title,
                    description = description,
                    category = note.category
                )
            )
        }
    }

    @Composable
    fun Preview() {
        val state = MainState()
        val listeners = object : MainListeners {
            override fun openNoteDetails(noteId: Int) {}
            override fun openNewNoteScreen() {}
            override fun createNewNote(noteData: NoteData) {}
            override fun updateNote(noteData: NoteData) {}
            override fun backToMainScreen() {}
        }
        Default(state, listeners)
    }
}