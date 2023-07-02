package com.ruzibekov.think.ui.screens.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.theme.Inter
import com.ruzibekov.think.ui.theme.ThinkColor
import com.ruzibekov.think.ui.theme.ThinkIcon

object SearchTextField {

    @Composable
    fun Default(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
    ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, ThinkColor.Gray),
            color = Color.Transparent
        ) {
            Row(
                Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = ThinkIcon.Search),
                    contentDescription = "search leading iocn",
                    modifier = Modifier.size(20.dp),
                    tint = ThinkColor.DarkGray
                )

                Spacer(modifier = Modifier.width(12.dp))

                Box {
                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(
                            fontFamily = Inter,
                            color = MaterialTheme.colorScheme.tertiary,
                            fontWeight = FontWeight.Normal
                        ),
                        maxLines = 1,
                         cursorBrush = SolidColor(MaterialTheme.colorScheme.tertiary)
                    )

                    if(value.isBlank())
                        Text(
                            text = stringResource(R.string.hint_search_notes),
                            style = MaterialTheme.typography.bodyMedium,
                            color = ThinkColor.Gray,
                            fontSize = 14.sp,
                        )
                }
            }
        }
    }
}