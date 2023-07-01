package com.ruzibekov.think.ui.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ruzibekov.data.model.NoteData
import com.ruzibekov.think.mock.MainMockito

data class MainState(
    val searchState: MutableState<String> = mutableStateOf(""),
    val selectedCategoryIndex: MutableState<Int> = mutableStateOf(0),
    val noteList: SnapshotStateList<NoteData> = mutableStateListOf(*MainMockito.noteList.toTypedArray()),
    val selectedNoteIndex: MutableState<Int> = mutableStateOf(0)
)