package com.ruzibekov.think.ui.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ruzibekov.data.model.NoteCategory
import com.ruzibekov.data.model.NoteData
import com.ruzibekov.think.mock.MainMockito
import com.ruzibekov.think.utils.Constants

data class MainState(
    val searchState: MutableState<String> = mutableStateOf(""),

    val categoryList: SnapshotStateList<NoteCategory> = mutableStateListOf(
        *NoteCategory.values().toList().toTypedArray()
    ),
    val selectedCategoryIndex: MutableState<Int> = mutableStateOf(Constants.AllCategoryIndex),

    val noteList: SnapshotStateList<NoteData> = mutableStateListOf(*MainMockito.noteList.toTypedArray()),
    val selectedNoteIndex: MutableState<Int> = mutableStateOf(0)
)