package com.ruzibekov.domain.usecase

import com.ruzibekov.domain.model.NoteData
import kotlinx.coroutines.flow.Flow

interface CreateNoteUseCase {

    suspend fun createNote(noteData: NoteData): Flow<Boolean>
}