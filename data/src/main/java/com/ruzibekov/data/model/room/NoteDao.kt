package com.ruzibekov.data.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ruzibekov.domain.model.NoteData

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createNote(noteData: NoteData)

    @Query("SELECT * FROM NoteData")
    fun getAll(): List<NoteData>

    @Update
    fun updateNote(noteData: NoteData)

    @Delete
    fun deleteNote(noteData: NoteData)
}