package com.example.flightsearch.data.local.room

data class SavableFlight(
    val id: Int,
    val departureCode: String,
    val departureName: String,
    val destinationCode: String,
    val destinationName: String,
    val isFavorite: Boolean
)