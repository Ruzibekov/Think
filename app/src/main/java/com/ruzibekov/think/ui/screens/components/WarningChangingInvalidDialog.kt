package com.ruzibekov.think.ui.screens.components

import androidx.compose.runtime.Composable
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.components.base.BaseWarningDialogView
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState

object WarningChangingInvalidDialog {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        BaseWarningDialogView.Default(
            state = state,
            listeners = listeners,
            textRes = R.string.warning_changing_invalid_text,
            onAccept = {
                listeners.onBackStack()
            },
            onDismiss = { state.showWarningChangesInvalidDialog.value = false }
        )
    }

}