package com.ruzibekov.think.ui.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ruzibekov.domain.model.NoteCategory
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.mock.MainMockito
import com.ruzibekov.data.model.constants.Constants

data class MainState(
    val searchState: MutableState<String> = mutableStateOf(""),

    val categoryList: SnapshotStateList<NoteCategory> = mutableStateListOf(*NoteCategory.values().toList().toTypedArray()),
    val selectedCategoryIndex: MutableState<Int> = mutableStateOf(Constants.AllCategoryIndex),

    val noteList: SnapshotStateList<NoteData> = mutableStateListOf(*MainMockito.noteList.toTypedArray()),
    val selectedNoteIndex: MutableState<Int> = mutableStateOf(0),

    )