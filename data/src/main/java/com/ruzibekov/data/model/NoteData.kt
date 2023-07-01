package com.ruzibekov.data.model

data class NoteData(
    val color: Int,
    val title: String,
    val description: String,
    val category: NoteCategory,
)

enum class NoteCategory(val title: String) {
    SHOPPING("Shopping"),
    TO_DO_LIST("To-do list"),
    IDEA("Ideas"),
    WORK("Working"),
}