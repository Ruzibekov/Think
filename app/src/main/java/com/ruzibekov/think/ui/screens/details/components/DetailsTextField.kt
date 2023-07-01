package com.ruzibekov.think.ui.screens.details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.ruzibekov.think.ui.theme.ThinkColor

object DetailsTextField {

    @Composable
    fun Default(
        value: String,
        onValueChange: (String) -> Unit,
        labelRes: Int,
        textStyle: TextStyle
    ) {
        Box {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = textStyle,
                maxLines = 1,
            )

            if (value.isBlank())
                Text(
                    text = stringResource(labelRes),
                    style = textStyle,
                    color = ThinkColor.Gray,
                    fontSize = 14.sp,
                )
        }
    }
}