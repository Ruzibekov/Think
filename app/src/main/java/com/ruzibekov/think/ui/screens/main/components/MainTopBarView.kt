package com.ruzibekov.think.ui.screens.main.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.ThinkColor
import com.ruzibekov.think.ui.theme.horizontalSpace

object MainTopBarView {

    @Composable
    fun Default(state: MainState) {
        Card(
            colors = CardDefaults.cardColors(containerColor = ThinkColor.White),
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
                    text = stringResource(R.string.app_name).uppercase(),
                    style = MaterialTheme.typography.titleSmall,
                    color = ThinkColor.Font,
                    fontSize = 24.sp,
                    letterSpacing = 2.16.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                SearchTextField.Default(
                    value = state.searchState.value,
                    onValueChange = { state.searchState.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = horizontalSpace)
                )

                Spacer(modifier = Modifier.height(18.dp))

                val context = LocalContext.current

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(
                        start = horizontalSpace,
                        end = horizontalSpace - 12.dp
                    )
                ) {
                    itemsIndexed(
                        context.resources.getStringArray(R.array.main_category_tabs)
                    ) { index, text ->
                        ItemTabView(
                            selected = state.selectedCategoryIndex.value == index,
                            text = text
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun ItemTabView(selected: Boolean, text: String) {
        Box(
            modifier = Modifier.padding(end = 12.dp)
        ) {
            if (selected)
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = ThinkColor.Primary
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        text = text,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = ThinkColor.White,
                    )
                }
            else
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, ThinkColor.LightGray),
                    color = Color.Transparent
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        text = text,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 12.sp,
                        color = ThinkColor.DarkGray,
                    )
                }
        }
    }
}