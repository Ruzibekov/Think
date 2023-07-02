package com.ruzibekov.data.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ruzibekov.domain.model.NoteData


@Database(entities = [NoteData::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun dao(): NoteDao
}