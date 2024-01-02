package com.example.flightsearch.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class FavoriteFlight(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "departure_code")
    val departureCode: String,
    @ColumnInfo(name = "destination_code")
    val destinationCode: String
) {
    fun toSavableFlight(departureName: String, destinationName: String): SavableFlight {
        return SavableFlight(
            id = id,
            departureCode = departureCode,
            departureName = departureName,
            destinationCode = destinationCode,
            destinationName = destinationName,
            isFavorite = true
        )
    }
}