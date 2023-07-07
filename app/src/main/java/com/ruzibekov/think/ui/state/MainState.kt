package com.ruzibekov.think.ui.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ruzibekov.data.model.constants.Constants
import com.ruzibekov.domain.model.NoteCategory
import com.ruzibekov.domain.model.NoteData

data class MainState(
    val searchState: MutableState<String> = mutableStateOf(""),

    val categoryList: SnapshotStateList<NoteCategory> = mutableStateListOf(
        *NoteCategory.values().toList().toTypedArray()
    ),
    val selectedCategoryIndex: MutableState<Int> = mutableStateOf(Constants.AllCategoryIndex),

    val noteList: SnapshotStateList<NoteData> = mutableStateListOf(),
    val selectedNote: MutableState<NoteData?> = mutableStateOf(null),

    val noteEditTitle: MutableState<String> = mutableStateOf(""),
    val noteEditDesc: MutableState<String> = mutableStateOf(""),
    val noteEditCategory: MutableState<NoteCategory> = mutableStateOf(NoteCategory.IDEA),

    val showCategoryChangeDialog: MutableState<Boolean> = mutableStateOf(false),
    val showWarningChangesInvalidDialog: MutableState<Boolean> = mutableStateOf(false),
    val showDeletionWarningDialog: MutableState<Boolean> = mutableStateOf(false),

    val isActiveSaveButton: MutableState<Boolean> = mutableStateOf(false)
){

    fun changeEditNoteData(
        title: String,
        description: String,
        category: NoteCategory
    ) {
        noteEditTitle.value = title
        noteEditDesc.value = description
        noteEditCategory.value = category
    }
}