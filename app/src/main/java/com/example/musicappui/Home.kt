package com.example.musicappui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Home() {
    var itemType = listOf("Top Hits", "Happy", "Gym", "Break-up", "Walk", "Relax")
    var category = listOf("Latest", "Top-Rated", "Most listened")
    LazyColumn() {
        items(category) {
            Text(text = it, Modifier.padding(8.dp))
            LazyRow {
                items(itemType) { item ->
                    Card(
                        modifier = Modifier
                            .height(256.dp)
                            .width(256.dp)
                            .padding(end = 16.dp),
                    ) {
                        Text(text = item, Modifier.fillMaxSize(), textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }

}