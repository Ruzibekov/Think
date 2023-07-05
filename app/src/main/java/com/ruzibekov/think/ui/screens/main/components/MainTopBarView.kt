package com.ruzibekov.think.ui.screens.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.data.model.constants.Constants
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.ThinkColor
import com.ruzibekov.think.ui.theme.space_20

object MainTopBarView {

    @Composable
    fun Default(state: MainState) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
            elevation = CardDefaults.cardElevation(5.dp),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 8.dp,
                bottomEnd = 8.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.app_name).uppercase(), //todo change text with figma
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 24.sp,
                    letterSpacing = 2.16.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                SearchTextField.Default(
                    value = state.searchState.value,
                    onValueChange = { state.searchState.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = space_20)
                )

                Spacer(modifier = Modifier.height(18.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(
                        start = space_20,
                        end = space_20 - 12.dp
                    )
                ) {

                    item {
                        ItemTabView(
                            selected = state.selectedCategoryIndex.value == Constants.AllCategoryIndex,
                            text = stringResource(id = R.string.category_all)
                        ) {
                            state.selectedCategoryIndex.value = Constants.AllCategoryIndex
                        }
                    }

                    itemsIndexed(state.categoryList) { index, category ->
                        ItemTabView(
                            selected = state.selectedCategoryIndex.value == index,
                            text = stringResource(id = category.titleRes)
                        ) {
                            state.selectedCategoryIndex.value = index
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ItemTabView(selected: Boolean, text: String, onClick: () -> Unit) {
        Box(
            modifier = Modifier.padding(end = 12.dp)
        ) {
            if (selected)
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = ThinkColor.Primary
                ) {
                    Text(
                        modifier = Modifier
                            .clickable { onClick() }
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        text = text,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = ThinkColor.White,
                    )
                }
            else //not selected
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, ThinkColor.LightGray),
                    color = Color.Transparent
                ) {
                    Text(
                        modifier = Modifier
                            .clickable { onClick() }
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        text = text,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                }
        }
    }
}