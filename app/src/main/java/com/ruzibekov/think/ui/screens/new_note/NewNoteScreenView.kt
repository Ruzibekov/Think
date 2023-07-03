package com.ruzibekov.think.ui.screens.new_note

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.ui.screens.components.BaseNoteDetailsScreenView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.ThinkColor

object NewNoteScreenView {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        BaseNoteDetailsScreenView.Default(
            state = state,
            listeners = listeners
        ) {
            listeners.createNewNote(
                NoteData(
                    color = getRandomColorArgb(),
                    title = state.noteEditTitle.value,
                    description = state.noteEditDesc.value,
                    category = state.noteEditCategory.value
                )
            )
        }
    }

    private fun getRandomColorArgb(): Int =
        listOf(
            ThinkColor.PinkLace,
            ThinkColor.Flavescent,
            ThinkColor.AzureishWhite,
            ThinkColor.MagicMint,
            ThinkColor.MistyRose
        ).random().toArgb()
}