package com.ruzibekov.data.model.di

import com.ruzibekov.data.model.repository.NoteRepository
import com.ruzibekov.domain.usecase.CreateNoteUseCase
import com.ruzibekov.domain.usecase.GetNoteListUseCase
import com.ruzibekov.domain.usecase.UpdateNoteUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)//todo change to viewmodel component
interface UseCasesModule {

    @Binds
    fun bindCreateNoteUseCase(repository: NoteRepository): CreateNoteUseCase

    @Binds
    fun bindGetNoteListUseCase(repository: NoteRepository): GetNoteListUseCase

    @Binds
    fun bindUpdateNoteUseCase(repository: NoteRepository): UpdateNoteUseCase
}