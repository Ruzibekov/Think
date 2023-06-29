package com.ruzibekov.think.ui.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class MainState(
    val searchState: MutableState<String> = mutableStateOf("")
)