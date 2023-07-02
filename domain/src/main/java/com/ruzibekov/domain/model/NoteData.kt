package com.ruzibekov.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("color") val color: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("category") val category: NoteCategory,
)

enum class NoteCategory(val title: String) {
    SHOPPING("Shopping"),
    TO_DO_LIST("To-do list"),
    IDEA("Ideas"),
    WORK("Working");
}