package com.ruzibekov.think.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.details.components.DetailsTextField
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.Inter
import com.ruzibekov.think.ui.theme.ThinkIcon
import com.ruzibekov.think.ui.theme.space_20

object BaseNoteDetailsScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(
        state: MainState,
        listeners: MainListeners,
        onDone: () -> Unit
    ) {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    IconButton(onClick = {
                        listeners.backToMainScreen()
                    }) {
                        Icon(
                            painter = painterResource(id = ThinkIcon.Back),
                            contentDescription = "back icon",
                            tint = MaterialTheme.colorScheme.tertiary,
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = state.noteEditCategory.value.title,
                        modifier = Modifier.clickable {
                            listeners.showCategoryChangeDialog()
                        },
                    )

                    IconButton(
                        onClick = onDone,
                        enabled = state.noteEditTitle.value.isNotBlank() &&
                                state.noteEditDesc.value.isNotBlank()
                    ) {
                        Icon(
                            painter = painterResource(id = ThinkIcon.Check),
                            contentDescription = "check icon",
                            tint = MaterialTheme.colorScheme.tertiary,
                        )
                    }
                }
            }
        ) { pv ->
            val focusManager = LocalFocusManager.current
            val descFocusRequest = remember { FocusRequester() }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pv)
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(space_20)
            ) {
                DetailsTextField.Default(
                    value = state.noteEditTitle.value,
                    onValueChange = { state.noteEditTitle.value = it },
                    labelRes = R.string.details_label_title,
                    textStyle = TextStyle(
                        fontFamily = Inter,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    onDone = { descFocusRequest.requestFocus() }
                )

                Spacer(modifier = Modifier.height(6.dp))

                DetailsTextField.Default(
                    value = state.noteEditDesc.value,
                    onValueChange = { state.noteEditDesc.value = it },
                    labelRes = R.string.details_label_description,
                    textStyle = TextStyle(
                        fontFamily = Inter,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    onDone = { focusManager.clearFocus() },
                    modifier = Modifier.focusRequester(descFocusRequest),
                )
            }
        }

        if (state.visibleCategoryChangeDialog.value)
            CategoryChangeDialog.Default(state = state)
    }
}