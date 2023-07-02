package com.ruzibekov.think.ui.screens.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.data.model.constants.Constants
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.screens.main.listeners.MainListeners
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.ThinkColor
import com.ruzibekov.think.ui.theme.space_20

object MainContentView {

    private val itemPadding = 18.dp

    /** if(this < horizontalSpace)*/

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Default(state: MainState, listeners: MainListeners) {
        when {
            state.noteList.isEmpty() ->
                Image(
                    painter = painterResource(id = R.drawable.img_create_your_first_note),
                    contentDescription = "create your first note image",
                    modifier = Modifier.fillMaxSize().padding(horizontal = space_20)
                )

            filterNoteList(state).isEmpty() ->
                Image(
                    painter = painterResource(id = R.drawable.img_file_not_found),
                    contentDescription = "file not found image",
                    modifier = Modifier.fillMaxSize().padding(horizontal = space_20)
                )

            else ->
                LazyVerticalStaggeredGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = StaggeredGridCells.Adaptive(170.dp),
                    contentPadding = PaddingValues(
                        start = space_20,
                        end = space_20 - itemPadding,
                        top = space_20,
                        bottom = space_20 - itemPadding
                    )
                ) {
                    itemsIndexed(filterNoteList(state)) { index, data ->
                        Item(noteData = data) {
                            listeners.openNoteDetails(index)
                        }
                    }
                }
        }
    }

    @Composable
    private fun Item(noteData: NoteData, onClick: () -> Unit) {
        Surface(
            modifier = Modifier.padding(end = itemPadding, bottom = itemPadding),
            shape = RoundedCornerShape(30.dp),
            color = Color(noteData.color)  //todo change color to data color
        ) {
            Column(modifier = Modifier
                .clickable { onClick() }
                .padding(vertical = 18.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = noteData.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = ThinkColor.Dark,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(9.dp))

                Text(
                    text = noteData.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = ThinkColor.Dark,
                    fontSize = 12.sp
                )
            }
        }
    }

    private fun filterNoteList(state: MainState): List<NoteData> {
        return if (state.selectedCategoryIndex.value != Constants.AllCategoryIndex)
            state.noteList.filter {
                it.title.contains(state.searchState.value) &&
                        it.category.title == (state.categoryList[state.selectedCategoryIndex.value]).title
            }
        else
            state.noteList.filter {
                it.title.contains(state.searchState.value)
            }
    }
}