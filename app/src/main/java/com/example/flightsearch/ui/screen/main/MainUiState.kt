package com.example.flightsearch.ui.screen.main

import com.example.flightsearch.data.local.room.Airport
import com.example.flightsearch.data.local.room.SavableFlight

data class MainUiState(
    val searchQuery: String = "",
    val favorites: List<SavableFlight> = emptyList(),
    val suggestions: List<Airport> = emptyList(),
    val isLoading: Boolean = true
)