package com.ruzibekov.think.ui.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruzibekov.think.R
import com.ruzibekov.think.ui.state.MainState
import com.ruzibekov.think.ui.theme.ThinkColor

object MainTopBarView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Default(state: MainState) {
        Card {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.app_name).uppercase(),
                    style = MaterialTheme.typography.titleSmall,
                    color = ThinkColor.Font,
                    fontSize = 24.sp,
                    letterSpacing = 2.16.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                TextField(
                    value = state.searchState.value,
                    onValueChange = { state.searchState.value = it },
                    modifier = Modifier.fillMaxWidth(),

                )
            }
        }
    }
}