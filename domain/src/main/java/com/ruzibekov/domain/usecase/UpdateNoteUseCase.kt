package com.ruzibekov.domain.usecase

import com.ruzibekov.domain.model.NoteData
import kotlinx.coroutines.flow.Flow

interface UpdateNoteUseCase {

    suspend fun updateNote(note: NoteData): Flow<Boolean>
}