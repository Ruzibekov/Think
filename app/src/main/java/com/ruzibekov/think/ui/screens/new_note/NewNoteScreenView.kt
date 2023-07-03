package com.ruzibekov.think.ui.screens.new_note

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import com.ruzibekov.domain.model.NoteCategory
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.ui.screens.base.BaseNoteDetailsScreenView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.theme.ThinkColor

object NewNoteScreenView {

    @Composable
    fun Default(listeners: MainListeners) {
        BaseNoteDetailsScreenView.Default(
            listeners = listeners
        ) { title, description ->
            listeners.createNewNote(
                NoteData(
                    color = getRandomColorArgb(),
                    title = title,
                    description = description,
                    category = NoteCategory.WORK //todo change category
                )
            )
        }
    }

    @Composable
    fun Preview() {
        val listeners = object : MainListeners {
            override fun openNoteDetails(noteId: Int) {}
            override fun openNewNoteScreen() {}
            override fun createNewNote(noteData: NoteData) {}
            override fun updateNote(noteData: NoteData) {}
            override fun backToMainScreen() {}
        }
        Default(listeners = listeners)
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