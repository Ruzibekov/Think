package com.ruzibekov.think.mock

import androidx.compose.ui.graphics.toArgb
import com.ruzibekov.data.model.NoteData
import com.ruzibekov.think.ui.theme.ThinkColor

object MainMockito {

    val noteList = listOf(
        NoteData(
            color = ThinkColor.AzureishWhite.toArgb(),
            title = "test",
            description = "fdsfdsfdfadsfadsfadsfadsfdsfn.ds,jn;adkljgfnekfnkjadsfndsjklndkjsagsadgf"
        ),
        NoteData(
            color = ThinkColor.PinkLace.toArgb(),
            title = "test",
            description = "fdsfdsfdsagsadgf"
        ),
        NoteData(
            color = ThinkColor.Flavescent.toArgb(),
            title = "test",
            description = "fdsfdsfdsagsadgffadsfdsafadsfdsafdsfdsafsadfdsfdsf"
        ),
        NoteData(
            color = ThinkColor.PinkLace.toArgb(),
            title = "test",
            description = "fdsfdsfdsagsadgf"
        )
    )
}