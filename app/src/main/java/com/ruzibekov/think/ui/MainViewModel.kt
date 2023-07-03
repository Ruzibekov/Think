package com.ruzibekov.think.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.domain.usecase.CreateNoteUseCase
import com.ruzibekov.domain.usecase.GetNoteListUseCase
import com.ruzibekov.domain.usecase.UpdateNoteUseCase
import com.ruzibekov.think.ui.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val getNoteListUseCase: GetNoteListUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
) : ViewModel() {

    val state = MainState()

    fun fetchNoteList() {
        viewModelScope.launch {
            getNoteListUseCase.getNoteList().collect { list ->
                state.noteList.apply {
                    clear()
                    addAll(list)
                }
            }
        }
    }

    fun createNewNote(noteData: NoteData, onSuccess: () -> Unit) {
        viewModelScope.launch {
            createNoteUseCase.createNote(noteData).collect { success ->
                if (success) onSuccess()
            }
        }
    }

    fun updateNote(noteData: NoteData, onSuccess: () -> Unit) {
        viewModelScope.launch {
            updateNoteUseCase.updateNote(noteData).collect { success ->
                if (success) onSuccess()
            }
        }
    }
}