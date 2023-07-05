package com.ruzibekov.think.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.ThinkTheme

object CategoryChangeDialog {

    @Composable
    fun Default(state: MainState) {
        var current by remember { mutableStateOf(state.noteEditCategory.value) }

        Dialog(onDismissRequest = { state.showCategoryChangeDialog.value = false }) {
            Card {
                Column(
                    modifier = Modifier.padding(horizontal = 28.dp, vertical = 38.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    state.categoryList.forEach { category ->

                        Row(
                            modifier = Modifier
                                .clip(MaterialTheme.shapes.medium)
                                .clickable { current = category },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = category.title == current.title,
                                onClick = { current = category }
                            )
                            Surface(
                                modifier = Modifier.fillMaxWidth(),
                                color = Color.Transparent
                            ) {
                                Text(
                                    text = category.title,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            state.noteEditCategory.value = current
                            state.showCategoryChangeDialog.value = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = stringResource(R.string.accept))
                    }
                }
            }
        }
    }

    @Composable
    fun Preview() {
        ThinkTheme {
            Default(state = MainState())
        }
    }
}