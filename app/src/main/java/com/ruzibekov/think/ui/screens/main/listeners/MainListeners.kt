package com.ruzibekov.think.ui.screens.main.listeners

import com.ruzibekov.domain.model.NoteData

interface MainListeners {

    fun openNoteDetails(noteId: Int)

    fun openNewNoteScreen()

    fun createNewNote(noteData: NoteData)

    fun updateNote(noteData: NoteData)

    fun backToMainScreen()

}