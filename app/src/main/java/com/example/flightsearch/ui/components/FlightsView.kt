package com.example.flightsearch.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flightsearch.data.local.room.FavoriteFlight
import com.example.flightsearch.data.local.room.SavableFlight

@Composable
fun FlightsView(
    title: String,
    list: List<SavableFlight>,
    onFavoriteClick: (FavoriteFlight) -> Unit,
    modifier: Modifier = Modifier
) {
    if (list.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = title)
        }
    } else {
        Column(modifier = modifier.fillMaxSize()) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(list) {
                    SavableFlightItem(savableFlight = it, onFavoriteClick = onFavoriteClick)
                }
            }
        }
    }
}