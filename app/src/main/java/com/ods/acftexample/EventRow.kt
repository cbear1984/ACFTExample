package com.ods.acftexample

import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun EventRow(
    item: String,
//    content: @Composable LazyItemScope.(item: T) -> Unit
) {
    OutlinedTextField(value = item, onValueChange = {})
}

@Preview(showBackground = true)
@Composable
fun EventRowPreview() {
    val gender by remember { mutableStateOf("male") }

    EventRow(
        item = gender
    )
}