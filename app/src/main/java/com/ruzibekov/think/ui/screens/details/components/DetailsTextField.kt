package com.ruzibekov.think.ui.screens.details.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.ruzibekov.think.ui.theme.ThinkColor

object DetailsTextField {

    @Composable
    fun Default(
        value: String,
        onValueChange: (String) -> Unit,
        labelRes: Int,
        textStyle: TextStyle,
        onDone: () -> Unit,
        modifier: Modifier = Modifier,
        maxLines: Int = Int.MAX_VALUE,
    ) {
        Box {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier.fillMaxWidth(),
                textStyle = textStyle,
                maxLines = maxLines,
                cursorBrush = SolidColor(MaterialTheme.colorScheme.tertiary),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { onDone() })
            )

            if (value.isBlank())
                Text(
                    text = stringResource(labelRes),
                    style = textStyle,
                    color = ThinkColor.Gray,
                )
        }
    }
}