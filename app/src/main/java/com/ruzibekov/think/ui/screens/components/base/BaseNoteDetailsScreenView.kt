package com.ruzibekov.think.ui.screens.components.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.components.CategoryChangeDialog
import com.ruzibekov.think.ui.screens.components.WarningChangingInvalidDialog
import com.ruzibekov.think.ui.screens.components.WarningDeletionDialog
import com.ruzibekov.think.ui.screens.details.components.DetailsTextField
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.Inter
import com.ruzibekov.think.ui.theme.ThinkColor
import com.ruzibekov.think.ui.theme.ThinkIcon
import com.ruzibekov.think.ui.theme.space_20

object BaseNoteDetailsScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        state: MainState,
        listeners: MainListeners,
        onDone: () -> Unit,
        onDeleteButton: Boolean = false,
    ) {
        val focusManager = LocalFocusManager.current
        val descFocusRequest = remember { FocusRequester() }

        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    ItemIcon(
                        icon = ThinkIcon.Back,
                        onClick = { listeners.showWarningCancelChangeDialog() }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    if (onDeleteButton)
                        ItemIcon(
                            icon = ThinkIcon.Delete,
                            onClick = {
                                state.selectedNote.value?.let { listeners.showDeletionWarningDialog() }
                            }
                        )

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = ThinkColor.Black_10
                    ) {
                        Text(
                            text = stringResource(id = state.noteEditCategory.value.titleRes),
                            modifier = Modifier
                                .clickable { listeners.showCategoryChangeDialog() }
                                .padding(horizontal = 8.dp, vertical = 3.dp),
                        )
                    }

                    ItemIcon(
                        icon = ThinkIcon.Check,
                        onClick = {
                            onDone()
                            focusManager.clearFocus()
                            state.isActiveSaveButton.value = false
                        },
                        enabled = state.isActiveSaveButton.value
                    )
                }
            }
        ) { pv ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pv)
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(space_20)
            ) {

                DetailsTextField.Default(
                    value = state.noteEditTitle.value,
                    onValueChange = {
                        state.noteEditTitle.value = it
                        state.isActiveSaveButton.value = checkIsActiveButton(state)
                    },
                    labelRes = R.string.details_label_title,
                    textStyle = TextStyle(
                        fontFamily = Inter,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )

                Spacer(modifier = Modifier.height(6.dp))

                DetailsTextField.Default(
                    value = state.noteEditDesc.value,
                    onValueChange = {
                        state.noteEditDesc.value = it
                        state.isActiveSaveButton.value = checkIsActiveButton(state)
                    },
                    labelRes = R.string.details_label_description,
                    textStyle = TextStyle(
                        fontFamily = Inter,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.focusRequester(descFocusRequest),
                )
            }
        }

        if (state.showCategoryChangeDialog.value)
            CategoryChangeDialog.Default(state = state)
        else if (state.showWarningChangesInvalid.value)
            WarningChangingInvalidDialog.Default(state, listeners)
        else if (state.showDeletionWarningDialog.value)
            WarningDeletionDialog.Default(state, listeners)
    }

    @Composable
    private fun ItemIcon(
        icon: Int,
        onClick: () -> Unit,
        enabled: Boolean = true
    ) {
        IconButton(
            onClick = onClick,
            enabled = enabled
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = "icon",
                tint = if (enabled) MaterialTheme.colorScheme.tertiary else ThinkColor.LightGray,
            )
        }
    }

    private fun checkIsActiveButton(state: MainState): Boolean {
        return state.noteEditTitle.value.isNotBlank() && state.noteEditDesc.value.isNotBlank()
    }
}