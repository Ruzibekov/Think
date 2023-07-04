package com.ruzibekov.think.ui.screens.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState

object WarningCancelChangingDialog {

    @Composable
    fun Default(state: MainState, listeners: MainListeners) {

        AlertDialog(
            onDismissRequest = {
                state.showWarningCancelChangingDialog.value = false
            },
            title = {
                Text(text = stringResource(R.string.warning))
            },
            text = {
                Text(text = stringResource(R.string.warning_cancel_changing_text))
            },
            dismissButton = {
                ButtonView(
                    textRes = R.string.cancel,
                    onClick = { state.showWarningCancelChangingDialog.value = false }
                )
            },
            confirmButton = {
                ButtonView(
                    textRes = R.string.accept,
                    onClick = {
                        state.showWarningCancelChangingDialog.value = false
                        listeners.onBackStack()
                    }
                )
            },
        )
    }

    @Composable
    private fun ButtonView(textRes: Int, onClick: () -> Unit) {
        Button(onClick = onClick) {
            Text(text = stringResource(textRes))
        }
    }
}