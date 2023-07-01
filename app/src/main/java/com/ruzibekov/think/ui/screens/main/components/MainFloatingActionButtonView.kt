package com.ruzibekov.think.ui.screens.main.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.theme.ThinkColor
import com.ruzibekov.think.ui.theme.ThinkIcon

object MainFloatingActionButtonView {

    @Composable
    fun Default(listeners: MainListeners) {
        FloatingActionButton(
            onClick = { listeners.openNewNoteScreen() },
            shape = CircleShape,
            containerColor = ThinkColor.Primary
        ) {
            Icon(
                painter = painterResource(id = ThinkIcon.Add),
                contentDescription = "add icon",
                tint = ThinkColor.White
            )
        }
    }
}