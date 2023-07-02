package com.ruzibekov.domain.usecase

import com.ruzibekov.domain.model.NoteData
import kotlinx.coroutines.flow.Flow

interface GetNoteListUseCase {

    suspend fun getNoteList(): Flow<List<NoteData>>
}