package com.ruzibekov.data.model.repository

import com.ruzibekov.data.model.room.NoteDao
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.domain.usecase.CreateNoteUseCase
import com.ruzibekov.domain.usecase.DeleteNoteUseCase
import com.ruzibekov.domain.usecase.GetNoteListUseCase
import com.ruzibekov.domain.usecase.UpdateNoteUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dao: NoteDao,
    private val ioDispatcher: CoroutineDispatcher,
) : CreateNoteUseCase, GetNoteListUseCase, UpdateNoteUseCase, DeleteNoteUseCase {

    override suspend fun createNote(noteData: NoteData): Flow<Boolean> = flow {
        emit(false)
        dao.createNote(noteData)
        emit(true)
    }.flowOn(ioDispatcher)

    override suspend fun getNoteList(): Flow<List<NoteData>> = flow {
        emit(dao.getAll())
    }.flowOn(ioDispatcher)

    override suspend fun updateNote(note: NoteData) = flow {
        emit(false)
        dao.updateNote(note)
        emit(true)
    }.flowOn(ioDispatcher)

    override suspend fun deleteNote(note: NoteData) = flow {
        dao.deleteNote(note)
        emit(true)
    }.flowOn(ioDispatcher)
}