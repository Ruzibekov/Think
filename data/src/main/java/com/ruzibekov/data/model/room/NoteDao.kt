package com.ruzibekov.data.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ruzibekov.domain.model.NoteData

@Dao
interface NoteDao {

    @Insert
    fun createNote(noteData: NoteData)

    @Query("SELECT * FROM NoteData")
    fun getAll(): List<NoteData>
}