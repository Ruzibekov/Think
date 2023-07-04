package com.ruzibekov.think.ui.screens.main.listeners

import com.ruzibekov.domain.model.NoteData

interface MainListeners {

    fun openNoteDetails(note: NoteData)

    fun openNewNoteScreen()

    fun createNewNote(noteData: NoteData)

    fun updateNote(noteData: NoteData)

    fun onBackStack()

    fun showCategoryChangeDialog()

    fun showWarningCancelChangeDialog()

    fun deleteNote(note: NoteData)
}