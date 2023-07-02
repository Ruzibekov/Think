package com.ruzibekov.domain.usecase

import com.ruzibekov.domain.model.NoteData

interface UpdateNoteUseCase {

    suspend fun updateNote(note: NoteData): kotlinx.coroutines.flow.Flow<Boolean>
}