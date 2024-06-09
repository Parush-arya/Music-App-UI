package com.example.musicappui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Browse() {
    var itemType = listOf("Top Hits", "Happy", "Gym", "Break-up", "Walk", "Relax")
    var category = listOf("Latest", "Top-Rated", "Most listened")
    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(itemType) { item ->
            Card(
                modifier = Modifier
                    .height(256.dp)
                    .width(256.dp)
                    .padding(8.dp),
            ) {
                Text(text = item, Modifier.fillMaxSize(), textAlign = TextAlign.Center)
            }
        }
    }
}
