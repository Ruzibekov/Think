package com.ruzibekov.data.model.di

import android.content.Context
import androidx.room.Room
import com.ruzibekov.data.model.constants.Constants
import com.ruzibekov.data.model.room.NoteDao
import com.ruzibekov.data.model.room.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideNoteDatabase(
        @ApplicationContext applicationContext: Context
    ): NoteDatabase =
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            Constants.NOTE_DATABASE_NAME
        ).build()

    @Provides
    fun provideNoteDao(database: NoteDatabase): NoteDao = database.dao()

    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
