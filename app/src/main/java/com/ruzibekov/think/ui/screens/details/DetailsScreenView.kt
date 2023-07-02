package com.ruzibekov.think.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.details.components.DetailsTextField
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.Inter
import com.ruzibekov.think.ui.theme.ThinkColor
import com.ruzibekov.think.ui.theme.ThinkIcon
import com.ruzibekov.think.ui.theme.space_20

object DetailsScreenView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        val note = state.noteList[state.selectedNoteIndex.value]

        var noteTitle by remember { mutableStateOf(note.title) }
        var noteDescription by remember { mutableStateOf(note.description) }

        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    IconButton(
                        onClick = { listeners.backToMainScreen() }
                    ) {
                        Icon(
                            painter = painterResource(id = ThinkIcon.Back),
                            contentDescription = "back icon",
                            tint = ThinkColor.Dark
                        )
                    }

                    IconButton(
                        onClick = {
                            listeners.updateNote(
                                NoteData(
                                    id = note.id,
                                    color = note.color,
                                    title = noteTitle,
                                    description = noteDescription,
                                    category = note.category
                                )
                            )
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = ThinkIcon.Check),
                            contentDescription = "check icon",
                            tint = ThinkColor.Dark
                        )
                    }
                }
            }
        ) { pv ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pv)
                    .background(ThinkColor.White)
                    .padding(space_20)
            ) {
                DetailsTextField.Default(
                    value = noteTitle,
                    onValueChange = { noteTitle = it },
                    labelRes = R.string.details_label_title,
                    textStyle = TextStyle(
                        fontFamily = Inter,
                        color = ThinkColor.Dark,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(6.dp))

                DetailsTextField.Default(
                    value = noteDescription,
                    onValueChange = { noteDescription = it },
                    labelRes = R.string.details_label_description,
                    textStyle = TextStyle(
                        fontFamily = Inter,
                        color = ThinkColor.Dark,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
    }

    @Composable
    fun Preview() {
        val state = MainState()
        val listeners = object : MainListeners{
            override fun openNoteDetails(noteId: Int) {}
            override fun openNewNoteScreen() {}
            override fun createNewNote(noteData: NoteData) {}
            override fun updateNote(noteData: NoteData) {}
            override fun backToMainScreen() {}
        }
        Default(state, listeners)
    }
}