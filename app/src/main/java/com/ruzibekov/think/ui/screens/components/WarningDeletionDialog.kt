package com.ruzibekov.think.ui.screens.components

import androidx.compose.runtime.Composable
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.components.base.BaseWarningDialogView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState

object WarningDeletionDialog {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        BaseWarningDialogView.Default(
            state = state,
            listeners = listeners,
            textRes = R.string.warning_deletion_text,
            onAccept = { state.selectedNote.value?.let { listeners.deleteNote(it) } },
            onDismiss = { state.showDeletionWarningDialog.value = false }
        )
    }
}