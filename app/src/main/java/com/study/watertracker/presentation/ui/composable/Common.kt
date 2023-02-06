package com.study.watertracker.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.study.watertracker.ui.theme.AccentBlue
import com.study.watertracker.ui.theme.Padding

@Preview
@Composable
fun SpinnerPreview(){
    Spinner(itemList = listOf("1", "2", "3"), selectedItem = "1", onItemSelected ={} )
}

@Composable
fun Spinner(
    itemList: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by rememberSaveable {
        mutableStateOf(false)
    }
    val modifier = Modifier.fillMaxWidth()

    OutlinedButton(onClick = { expanded = true }) {
        Text(
            text = selectedItem,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = modifier,
            color = AccentBlue
        )
    }
    DropdownMenu(
        expanded = expanded,
        modifier = modifier
            .padding(Padding.SCREENS.value)
            .background(Color.White),
        onDismissRequest = { expanded = false }) {
        itemList.forEach {
            DropdownMenuItem(
                modifier = modifier,
                onClick = {
                    expanded = false
                    onItemSelected(it)
                }) {
                Text(text = it)
            }
        }
    }
}
