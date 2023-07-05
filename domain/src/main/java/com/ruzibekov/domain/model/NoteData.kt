package com.ruzibekov.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ruzibekov.domain.R

@Entity
data class NoteData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("color") val color: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("category") val category: NoteCategory,
)

enum class NoteCategory(val titleRes: Int) {
    SHOPPING(R.string.category_shopping),
    TO_DO_LIST(R.string.category_todo_list),
    IDEA(R.string.category_ideas),
    WORK(R.string.category_working);
}