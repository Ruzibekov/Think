package com.ruzibekov.think.ui.screens.components.base

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.ThinkColor

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
                    onClick = { onDismiss() },
                    buttonColor = ThinkColor.Red
                )
            },
            confirmButton = {
                ButtonView(
                    textRes = R.string.accept,
                    onClick = {
                        onAccept()
                        onDismiss()
                    },
                    buttonColor = ThinkColor.Green
                )
            }
        )
    }

    @Composable
    private fun ButtonView(
        textRes: Int,
        onClick: () -> Unit,
        buttonColor: Color = ThinkColor.Black
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text(text = stringResource(textRes))
        }
    }
}