package com.example.flightsearch.data.local

import com.example.flightsearch.data.local.room.SavableFlight


object SavableFlightProvider {

    val savableFlights: Map<String, List<SavableFlight>>
        get() =
            AirportProvider.list.groupBy { it.code }.mapValues { it.key.getSavableFlights() }

}

fun String.getSavableFlights(): List<SavableFlight> {
    val mine = AirportProvider.list.filter { it.code == this }
    val notMine = AirportProvider.list.filterNot { it.code == this }
    val myAirport = mine.first()
    var countId = myAirport.id * notMine.size
    val list = notMine.map {
        SavableFlight(
            id = countId++,
            departureCode = this,
            departureName = myAirport.name,
            destinationCode = it.code,
            destinationName = it.name,
            isFavorite = false
        )
    }
    return list
}