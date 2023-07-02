package com.ruzibekov.think.mock

import androidx.compose.ui.graphics.toArgb
import com.ruzibekov.domain.model.NoteCategory
import com.ruzibekov.domain.model.NoteData
import com.ruzibekov.think.ui.theme.ThinkColor

object MainMockito {

    val noteList = listOf(
        NoteData(
            color = ThinkColor.AzureishWhite.toArgb(),
            title = "test",
            description = "fdsfdsfdfadsfadsfadsfadsfdsfn.ds,jn;adkljgfnekfnkjadsfndsjklndkjsagsadgf",
            category = NoteCategory.TO_DO_LIST
        ),
        NoteData(
            color = ThinkColor.PinkLace.toArgb(),
            title = "test",
            description = "fdsfdsfdsagsadgf",
            category = NoteCategory.WORK
        ),
        NoteData(
            color = ThinkColor.Flavescent.toArgb(),
            title = "test",
            description = "fdsfdsfdsagsadgffadsfdsafadsfdsafdsfdsafsadfdsfdsf",
            category = NoteCategory.SHOPPING
        ),
        NoteData(
            color = ThinkColor.PinkLace.toArgb(),
            title = "test",
            description = "fdsfdsfdsagsadgf",
            category = NoteCategory.SHOPPING
        )
    )
}