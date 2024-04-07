package com.nuhin13.giphy.features.giphylist.presentaion

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nuhin13.giphy.ui.theme.GIPHYTheme


@Composable
fun GiphySearchItem() {
    Text(text = "Giphy Search Item")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GIPHYTheme {
        GiphySearchItem()
    }
}