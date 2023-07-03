package com.ruzibekov.domain.usecase

import com.ruzibekov.domain.model.NoteData
import kotlinx.coroutines.flow.Flow

interface DeleteNoteUseCase {

    suspend fun deleteNote(note: NoteData): Flow<Boolean>
}