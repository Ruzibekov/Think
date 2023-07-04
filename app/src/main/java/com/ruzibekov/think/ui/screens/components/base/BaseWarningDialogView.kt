package com.ruzibekov.think.ui.screens.components.base

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState

object BaseWarningDialogView {

    @Composable
    fun Default(
        state: MainState,
        listeners: MainListeners,
        textRes: Int,
        onAccept: () -> Unit,
        onDismiss: () -> Unit
    ) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = stringResource(R.string.warning))
            },
            text = {
                Text(text = stringResource(textRes))
            },
            dismissButton = {
                ButtonView(
                    textRes = R.string.cancel,
                    onClick = { onDismiss() }
                )
            },
            confirmButton = {
                ButtonView(
                    textRes = R.string.accept,
                    onClick = {
                        onAccept()
                        onDismiss()
                    }
                )
            }
        )
    }

    @Composable
    private fun ButtonView(textRes: Int, onClick: () -> Unit) {
        Button(onClick = onClick) {
            Text(text = stringResource(textRes))
        }
    }
}